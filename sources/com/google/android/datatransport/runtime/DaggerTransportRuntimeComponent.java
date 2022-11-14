package com.google.android.datatransport.runtime;

import android.content.Context;
import com.android.billingclient.api.zzam;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {
    public Provider<SchedulerConfig> configProvider;
    public Provider creationContextFactoryProvider;
    public Provider<DefaultScheduler> defaultSchedulerProvider;
    public Provider<Executor> executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory.INSTANCE);
    public Provider metadataBackendRegistryProvider;
    public Provider<SQLiteEventStore> sQLiteEventStoreProvider;
    public Provider schemaManagerProvider;
    public Provider<Context> setApplicationContextProvider;
    public Provider<TransportRuntime> transportRuntimeProvider;
    public Provider<Uploader> uploaderProvider;
    public Provider<WorkInitializer> workInitializerProvider;
    public Provider<WorkScheduler> workSchedulerProvider;

    /* JADX WARNING: type inference failed for: r2v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory] */
    /* JADX WARNING: type inference failed for: r2v2, types: [javax.inject.Provider, dagger.internal.InstanceFactory, javax.inject.Provider<android.content.Context>] */
    /* JADX WARNING: type inference failed for: r1v1, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r3v1, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: type inference failed for: r4v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory] */
    /* JADX WARNING: type inference failed for: r2v3, types: [javax.inject.Provider, com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory] */
    /* JADX WARNING: type inference failed for: r2v4, types: [com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory, javax.inject.Provider] */
    /* JADX WARNING: type inference failed for: r3v2, types: [javax.inject.Provider, com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory] */
    /* JADX WARNING: type inference failed for: r1v5, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r2v5, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: type inference failed for: r4v1, types: [com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory, javax.inject.Provider] */
    /* JADX WARNING: type inference failed for: r5v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory] */
    /* JADX WARNING: type inference failed for: r1v7, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r2v6, types: [javax.inject.Provider, com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory, javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig>] */
    /* JADX WARNING: type inference failed for: r4v2, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: type inference failed for: r8v0, types: [com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory, javax.inject.Provider, javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler>] */
    /* JADX WARNING: type inference failed for: r18v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r9v1, types: [javax.inject.Provider, javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer>, com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory] */
    /* JADX WARNING: type inference failed for: r5v2, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r6v1, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    public DaggerTransportRuntimeComponent(Context context, C16141 r21) {
        Context context2 = context;
        zzam.checkNotNull1(context2, "instance cannot be null");
        ? instanceFactory = new InstanceFactory(context2);
        this.setApplicationContextProvider = instanceFactory;
        ? creationContextFactory_Factory = new CreationContextFactory_Factory(instanceFactory, TimeModule_EventClockFactory.INSTANCE, TimeModule_UptimeClockFactory.INSTANCE);
        this.creationContextFactoryProvider = creationContextFactory_Factory;
        this.metadataBackendRegistryProvider = DoubleCheck.provider(new MetadataBackendRegistry_Factory(this.setApplicationContextProvider, creationContextFactory_Factory));
        ? schemaManager_Factory = new SchemaManager_Factory(this.setApplicationContextProvider, EventStoreModule_SchemaVersionFactory.INSTANCE);
        this.schemaManagerProvider = schemaManager_Factory;
        this.sQLiteEventStoreProvider = DoubleCheck.provider(new SQLiteEventStore_Factory(TimeModule_EventClockFactory.INSTANCE, TimeModule_UptimeClockFactory.INSTANCE, EventStoreModule_StoreConfigFactory.INSTANCE, schemaManager_Factory));
        ? schedulingConfigModule_ConfigFactory = new SchedulingConfigModule_ConfigFactory(TimeModule_EventClockFactory.INSTANCE);
        this.configProvider = schedulingConfigModule_ConfigFactory;
        ? schedulingModule_WorkSchedulerFactory = new SchedulingModule_WorkSchedulerFactory(this.setApplicationContextProvider, this.sQLiteEventStoreProvider, schedulingConfigModule_ConfigFactory, TimeModule_UptimeClockFactory.INSTANCE);
        this.workSchedulerProvider = schedulingModule_WorkSchedulerFactory;
        Provider<Executor> provider = this.executorProvider;
        Provider provider2 = this.metadataBackendRegistryProvider;
        Provider<SQLiteEventStore> provider3 = this.sQLiteEventStoreProvider;
        this.defaultSchedulerProvider = new DefaultScheduler_Factory(provider, provider2, schedulingModule_WorkSchedulerFactory, provider3, provider3);
        Provider<Context> provider4 = this.setApplicationContextProvider;
        Provider provider5 = this.metadataBackendRegistryProvider;
        Provider<SQLiteEventStore> provider6 = this.sQLiteEventStoreProvider;
        Provider<SQLiteEventStore> provider7 = provider6;
        this.uploaderProvider = new Uploader_Factory(provider4, provider5, provider7, this.workSchedulerProvider, this.executorProvider, provider6, TimeModule_EventClockFactory.INSTANCE);
        Provider<Executor> provider8 = this.executorProvider;
        Provider<SQLiteEventStore> provider9 = this.sQLiteEventStoreProvider;
        ? workInitializer_Factory = new WorkInitializer_Factory(provider8, provider9, this.workSchedulerProvider, provider9);
        this.workInitializerProvider = workInitializer_Factory;
        this.transportRuntimeProvider = DoubleCheck.provider(new TransportRuntime_Factory(TimeModule_EventClockFactory.INSTANCE, TimeModule_UptimeClockFactory.INSTANCE, this.defaultSchedulerProvider, this.uploaderProvider, workInitializer_Factory));
    }
}
