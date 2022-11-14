package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.vungle.warren.analytics.VungleAnalytics;
import com.vungle.warren.downloader.AssetDownloader;
import com.vungle.warren.downloader.CleverCache;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.downloader.DownloaderCache;
import com.vungle.warren.downloader.LRUCachePolicy;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.omsdk.OMTracker;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.Designer;
import com.vungle.warren.persistence.FilePreferences;
import com.vungle.warren.persistence.GraphicDesigner;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobCreator;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.ReconfigJob;
import com.vungle.warren.tasks.VungleJobCreator;
import com.vungle.warren.tasks.utility.JobRunnerThreadPriorityHelper;
import com.vungle.warren.utility.AppSession;
import com.vungle.warren.utility.ConcurrencyTimeoutProvider;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.NetworkProvider;
import com.vungle.warren.utility.SDKExecutors;
import com.vungle.warren.utility.TimeoutProvider;
import com.vungle.warren.utility.platform.AndroidPlatform;
import com.vungle.warren.utility.platform.Platform;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class ServiceLocator {
    @SuppressLint({"StaticFieldLeak"})
    public static ServiceLocator INSTANCE;
    public static final ReconfigJob.ReconfigCall RECONFIG_CALL = new ReconfigJob.ReconfigCall() {
        public void reConfigVungle() {
            Vungle.reConfigure();
        }
    };
    @VisibleForTesting
    public static final VungleStaticApi VUNGLE_STATIC_API = new VungleStaticApi() {
        public Collection<String> getValidPlacements() {
            return Vungle.getValidPlacements();
        }

        public boolean isInitialized() {
            return Vungle.isInitialized();
        }
    };
    public Map<Class, Object> cache = new HashMap();
    public Map<Class, Creator> creators = new HashMap();
    public final Context ctx;

    public abstract class Creator<T> {
        public Creator() {
        }

        public abstract T create();

        public boolean isSingleton() {
            return true;
        }
    }

    public ServiceLocator(@NonNull Context context) {
        this.ctx = context.getApplicationContext();
        buildCreators();
    }

    private void buildCreators() {
        this.creators.put(JobCreator.class, new Creator() {
            public JobCreator create() {
                Class<VungleApiClient> cls = VungleApiClient.class;
                Class<Repository> cls2 = Repository.class;
                return new VungleJobCreator((Repository) ServiceLocator.this.getOrBuild(cls2), (Designer) ServiceLocator.this.getOrBuild(Designer.class), (VungleApiClient) ServiceLocator.this.getOrBuild(cls), new VungleAnalytics((VungleApiClient) ServiceLocator.this.getOrBuild(cls), (Repository) ServiceLocator.this.getOrBuild(cls2)), ServiceLocator.RECONFIG_CALL, (AdLoader) ServiceLocator.this.getOrBuild(AdLoader.class), ServiceLocator.VUNGLE_STATIC_API, (LogManager) ServiceLocator.this.getOrBuild(LogManager.class), ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getBackgroundExecutor());
            }
        });
        this.creators.put(JobRunner.class, new Creator() {
            public JobRunner create() {
                return new VungleJobRunner((JobCreator) ServiceLocator.this.getOrBuild(JobCreator.class), ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getJobExecutor(), new JobRunnerThreadPriorityHelper(), NetworkProvider.getInstance(ServiceLocator.this.ctx));
            }
        });
        this.creators.put(AdLoader.class, new Creator() {
            public AdLoader create() {
                return new AdLoader((Executors) ServiceLocator.this.getOrBuild(Executors.class), (Repository) ServiceLocator.this.getOrBuild(Repository.class), (VungleApiClient) ServiceLocator.this.getOrBuild(VungleApiClient.class), (CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class), (Downloader) ServiceLocator.this.getOrBuild(Downloader.class), (RuntimeValues) ServiceLocator.this.getOrBuild(RuntimeValues.class), (VungleStaticApi) ServiceLocator.this.getOrBuild(VungleStaticApi.class), (VisionController) ServiceLocator.this.getOrBuild(VisionController.class), (OperationSequence) ServiceLocator.this.getOrBuild(OperationSequence.class), (OMInjector) ServiceLocator.this.getOrBuild(OMInjector.class));
            }
        });
        this.creators.put(Downloader.class, new Creator() {
            public Downloader create() {
                return new AssetDownloader((DownloaderCache) ServiceLocator.this.getOrBuild(DownloaderCache.class), AssetDownloader.VERIFICATION_WINDOW, 4, NetworkProvider.getInstance(ServiceLocator.this.ctx), ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getUIExecutor());
            }
        });
        this.creators.put(VungleApiClient.class, new Creator() {
            public VungleApiClient create() {
                return new VungleApiClient(ServiceLocator.this.ctx, (CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class), (Repository) ServiceLocator.this.getOrBuild(Repository.class), (OMInjector) ServiceLocator.this.getOrBuild(OMInjector.class));
            }
        });
        this.creators.put(Repository.class, new Creator() {
            public Repository create() {
                Executors executors = (Executors) ServiceLocator.this.getOrBuild(Executors.class);
                return new Repository(ServiceLocator.this.ctx, (Designer) ServiceLocator.this.getOrBuild(Designer.class), executors.getIOExecutor(), executors.getUIExecutor());
            }
        });
        this.creators.put(LogManager.class, new Creator() {
            public Object create() {
                return new LogManager(ServiceLocator.this.ctx, (CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class), (VungleApiClient) ServiceLocator.this.getOrBuild(VungleApiClient.class), (Executor) ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getLoggerExecutor(), (FilePreferences) ServiceLocator.this.getOrBuild(FilePreferences.class));
            }
        });
        this.creators.put(Designer.class, new Creator() {
            public Designer create() {
                return new GraphicDesigner((CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class));
            }
        });
        this.creators.put(CacheManager.class, new Creator() {
            public CacheManager create() {
                return new CacheManager(ServiceLocator.this.ctx, (FilePreferences) ServiceLocator.this.getOrBuild(FilePreferences.class));
            }
        });
        this.creators.put(Platform.class, new Creator<Platform>() {
            public Platform create() {
                return new AndroidPlatform();
            }
        });
        this.creators.put(Executors.class, new Creator() {
            public Executors create() {
                return new SDKExecutors();
            }
        });
        this.creators.put(RuntimeValues.class, new Creator() {
            public RuntimeValues create() {
                return new RuntimeValues();
            }
        });
        this.creators.put(VungleStaticApi.class, new Creator() {
            public VungleStaticApi create() {
                return ServiceLocator.VUNGLE_STATIC_API;
            }
        });
        this.creators.put(PresentationFactory.class, new Creator() {
            public boolean isSingleton() {
                return false;
            }

            public PresentationFactory create() {
                return new AdvertisementPresentationFactory((AdLoader) ServiceLocator.this.getOrBuild(AdLoader.class), (VungleStaticApi) ServiceLocator.this.getOrBuild(VungleStaticApi.class), (Repository) ServiceLocator.this.getOrBuild(Repository.class), (VungleApiClient) ServiceLocator.this.getOrBuild(VungleApiClient.class), (JobRunner) ServiceLocator.this.getOrBuild(JobRunner.class), (RuntimeValues) ServiceLocator.this.getOrBuild(RuntimeValues.class), (OMTracker.Factory) ServiceLocator.this.getOrBuild(OMTracker.Factory.class), ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getTaskExecutor());
            }
        });
        this.creators.put(DownloaderCache.class, new Creator() {
            public Object create() {
                CacheManager cacheManager = (CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class);
                return new CleverCache(cacheManager, new LRUCachePolicy(cacheManager, "clever_cache"), new DownloaderSizeProvider(cacheManager, (RuntimeValues) ServiceLocator.this.getOrBuild(RuntimeValues.class), 0.1f), TimeUnit.DAYS.toMillis(90));
            }
        });
        this.creators.put(VisionController.class, new Creator() {
            public VisionController create() {
                return new VisionController((Repository) ServiceLocator.this.getOrBuild(Repository.class), NetworkProvider.getInstance(ServiceLocator.this.ctx));
            }
        });
        this.creators.put(TimeoutProvider.class, new Creator() {
            public TimeoutProvider create() {
                return new ConcurrencyTimeoutProvider();
            }
        });
        this.creators.put(OperationSequence.class, new Creator() {
            public OperationSequence create() {
                return new OperationSequence();
            }
        });
        this.creators.put(AppSession.class, new Creator<AppSession>() {
            public AppSession create() {
                return new AppSession();
            }
        });
        this.creators.put(OMInjector.class, new Creator<OMInjector>() {
            public OMInjector create() {
                return new OMInjector(ServiceLocator.this.ctx);
            }
        });
        this.creators.put(OMTracker.Factory.class, new Creator<OMTracker.Factory>() {
            public OMTracker.Factory create() {
                return new OMTracker.Factory();
            }
        });
        this.creators.put(CacheBustManager.class, new Creator<CacheBustManager>() {
            public CacheBustManager create() {
                return new CacheBustManager((JobRunner) ServiceLocator.this.getOrBuild(JobRunner.class));
            }
        });
        this.creators.put(FilePreferences.class, new Creator<FilePreferences>() {
            public FilePreferences create() {
                return new FilePreferences(ServiceLocator.this.ctx, ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getIOExecutor());
            }
        });
    }

    public static synchronized void deInit() {
        synchronized (ServiceLocator.class) {
            INSTANCE = null;
        }
    }

    public static synchronized ServiceLocator getInstance(@NonNull Context context) {
        ServiceLocator serviceLocator;
        synchronized (ServiceLocator.class) {
            if (INSTANCE == null) {
                INSTANCE = new ServiceLocator(context);
            }
            serviceLocator = INSTANCE;
        }
        return serviceLocator;
    }

    /* access modifiers changed from: private */
    public <T> T getOrBuild(@NonNull Class<T> cls) {
        Class serviceClass = getServiceClass(cls);
        T t = this.cache.get(serviceClass);
        if (t != null) {
            return t;
        }
        Creator creator = this.creators.get(serviceClass);
        if (creator != null) {
            T create = creator.create();
            if (creator.isSingleton()) {
                this.cache.put(serviceClass, create);
            }
            return create;
        }
        throw new IllegalArgumentException("Unknown class");
    }

    @NonNull
    private Class getServiceClass(@NonNull Class cls) {
        for (Class next : this.creators.keySet()) {
            if (next.isAssignableFrom(cls)) {
                return next;
            }
        }
        throw new IllegalArgumentException("Unknown dependency for " + cls);
    }

    @VisibleForTesting
    public synchronized <T> void bindService(Class<T> cls, T t) {
        this.cache.put(getServiceClass(cls), t);
    }

    public synchronized <T> T getService(Class<T> cls) {
        return getOrBuild(cls);
    }

    public synchronized <T> boolean isCreated(Class<T> cls) {
        return this.cache.containsKey(getServiceClass(cls));
    }
}
