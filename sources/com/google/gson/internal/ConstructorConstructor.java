package com.google.gson.internal;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {
    public final ReflectionAccessor accessor = ReflectionAccessor.instance;
    public final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        C23863 r4;
        final Type type = typeToken.getType();
        final Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>(this) {
                public T construct() {
                    return instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>(this) {
                public T construct() {
                    return instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> objectConstructor = null;
        try {
            final Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.accessor.makeAccessible(declaredConstructor);
            }
            r4 = new ObjectConstructor<T>(this) {
                public T construct() {
                    try {
                        return declaredConstructor.newInstance((Object[]) null);
                    } catch (InstantiationException e) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to invoke ");
                        outline24.append(declaredConstructor);
                        outline24.append(" with no args");
                        throw new RuntimeException(outline24.toString(), e);
                    } catch (InvocationTargetException e2) {
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Failed to invoke ");
                        outline242.append(declaredConstructor);
                        outline242.append(" with no args");
                        throw new RuntimeException(outline242.toString(), e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            r4 = null;
        }
        if (r4 != null) {
            return r4;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new TreeSet();
                    }
                };
            } else if (EnumSet.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        Type type = type;
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return EnumSet.noneOf((Class) type2);
                            }
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Invalid EnumSet type: ");
                            outline24.append(type.toString());
                            throw new JsonIOException(outline24.toString());
                        }
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Invalid EnumSet type: ");
                        outline242.append(type.toString());
                        throw new JsonIOException(outline242.toString());
                    }
                };
            } else if (Set.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new LinkedHashSet();
                    }
                };
            } else if (Queue.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new ArrayDeque();
                    }
                };
            } else {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new ArrayList();
                    }
                };
            }
        } else if (Map.class.isAssignableFrom(rawType)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new ConcurrentSkipListMap();
                    }
                };
            } else if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new ConcurrentHashMap();
                    }
                };
            } else if (SortedMap.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new TreeMap();
                    }
                };
            } else if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new LinkedTreeMap();
                    }
                };
            } else {
                objectConstructor = new ObjectConstructor<T>(this) {
                    public T construct() {
                        return new LinkedHashMap();
                    }
                };
            }
        }
        if (objectConstructor != null) {
            return objectConstructor;
        }
        return new ObjectConstructor<T>(this) {
            public final UnsafeAllocator unsafeAllocator;

            {
                UnsafeAllocator unsafeAllocator2;
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    unsafeAllocator2 = new UnsafeAllocator(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get((Object) null)) {
                        public final /* synthetic */ Method val$allocateInstance;
                        public final /* synthetic */ Object val$unsafe;

                        {
                            this.val$allocateInstance = r1;
                            this.val$unsafe = r2;
                        }

                        public <T> T newInstance(Class<T> cls) throws Exception {
                            UnsafeAllocator.assertInstantiable(cls);
                            return this.val$allocateInstance.invoke(this.val$unsafe, new Object[]{cls});
                        }
                    };
                } catch (Exception unused) {
                    try {
                        Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                        declaredMethod.setAccessible(true);
                        int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                        Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                        declaredMethod2.setAccessible(true);
                        unsafeAllocator2 = new UnsafeAllocator(declaredMethod2, intValue) {
                            public final /* synthetic */ int val$constructorId;
                            public final /* synthetic */ Method val$newInstance;

                            {
                                this.val$newInstance = r1;
                                this.val$constructorId = r2;
                            }

                            public <T> T newInstance(Class<T> cls) throws Exception {
                                UnsafeAllocator.assertInstantiable(cls);
                                return this.val$newInstance.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.val$constructorId)});
                            }
                        };
                    } catch (Exception unused2) {
                        try {
                            Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                            declaredMethod3.setAccessible(true);
                            unsafeAllocator2 = new UnsafeAllocator(declaredMethod3) {
                                public final /* synthetic */ Method val$newInstance;

                                {
                                    this.val$newInstance = r1;
                                }

                                public <T> T newInstance(Class<T> cls) throws Exception {
                                    UnsafeAllocator.assertInstantiable(cls);
                                    return this.val$newInstance.invoke((Object) null, new Object[]{cls, Object.class});
                                }
                            };
                        } catch (Exception unused3) {
                            unsafeAllocator2 = new UnsafeAllocator() {
                                public <T> T newInstance(Class<T> cls) {
                                    throw new UnsupportedOperationException("Cannot allocate " + cls);
                                }
                            };
                        }
                    }
                }
                this.unsafeAllocator = unsafeAllocator2;
            }

            public T construct() {
                try {
                    return this.unsafeAllocator.newInstance(rawType);
                } catch (Exception e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to invoke no-args constructor for ");
                    outline24.append(type);
                    outline24.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(outline24.toString(), e);
                }
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
