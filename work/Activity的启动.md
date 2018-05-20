## Activity的启动流程
***
##### 努力工作
*自己平时工作接触的frameworks代码比较多，但真正理解的很有限，一直在努力分析。。我主要还是用补丁的形式来看*
***
```
 core/java/android/app/Activity.java                |  6 +++
 core/java/android/app/ActivityManagerNative.java   | 14 ++++-
 core/java/android/app/ActivityThread.java          | 63 +++++++++++++++++++++-
 core/java/android/app/ApplicationThreadNative.java |  7 +++
 core/java/android/app/IApplicationThread.java      |  8 +++
 core/java/android/app/Instrumentation.java         | 16 ++++++
 .../android/server/am/ActivityManagerService.java  | 10 +++-
 .../java/com/android/server/am/ActivityStack.java  | 12 ++++-
 .../android/server/am/ActivityStackSupervisor.java | 51 +++++++++++++++++-
 9 files changed, 181 insertions(+), 6 deletions(-)

diff --git a/core/java/android/app/Activity.java b/core/java/android/app/Activity.java
index 4b705dd..527cc38 100644
--- a/core/java/android/app/Activity.java
+++ b/core/java/android/app/Activity.java
@@ -3731,6 +3731,12 @@ public class Activity extends ContextThemeWrapper
      *
      * @see #startActivity
      */
+
+    /**
+     *Created by Smaster / one;
+     *  mParent代表的是ActivityGroup, ActivityGroup最开始被用来在一个界面中嵌入多个Activity.
+     *  --> Instrumentation execStartActivity()方法
+     * */
     public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
         if (mParent == null) {
             Instrumentation.ActivityResult ar =
diff --git a/core/java/android/app/ActivityManagerNative.java b/core/java/android/app/ActivityManagerNative.java
index 4e2ff0b..6ca7a32 100644
--- a/core/java/android/app/ActivityManagerNative.java
+++ b/core/java/android/app/ActivityManagerNative.java
@@ -78,6 +78,11 @@ public abstract class ActivityManagerNative extends Binder implements IActivityM
     /**
      * Retrieve the system's default/global activity manager.
      */
+    /** 
+     * created by Smaster / three;
+     *
+     *
+     * */
     static public IActivityManager getDefault() {
         return gDefault.get();
     }
@@ -2337,7 +2342,14 @@ public abstract class ActivityManagerNative extends Binder implements IActivityM
     public IBinder asBinder() {
         return this;
     }
-
+    
+    /**
+     *created by Smaster / four;
+     * 单利封装，　在后续的调用中直接返回之前创建的对象。
+     *
+     * －－－－> AMS startActivity.
+     *
+     * */
     private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {
         protected IActivityManager create() {
             IBinder b = ServiceManager.getService("activity");
diff --git a/core/java/android/app/ActivityThread.java b/core/java/android/app/ActivityThread.java
index dd49009..6ef3729 100644
--- a/core/java/android/app/ActivityThread.java
+++ b/core/java/android/app/ActivityThread.java
@@ -545,7 +545,21 @@ public final class ActivityThread {
     }
 
     private native void dumpGraphicsInfo(FileDescriptor fd);
+ 
+    /**
+     * created by Smaster / nineteen;
+     *   继承ApplicationThreadNative, ApplicationThreadNative 继承Binder ;
+     *   并实现IApplicationThread接口，
+     *   类似AIDL 
+     *   ApplicationThreadNative 中　--> ApplicationThreadProxy类。
+     * */
 
+    /**
+     * created by Smaster / twenty-one;
+     *  再次从ApplicationThreadNative中归来；
+     *　ApplicationThread 是真正实现IApplicationThread的类；
+     *  --> scheduleLaunchActivity --> 启动Activity.
+     * */
     private class ApplicationThread extends ApplicationThreadNative {
         private static final String ONE_COUNT_COLUMN = "%21s %8d";
         private static final String TWO_COUNT_COLUMNS = "%21s %8d %21s %8d";
@@ -603,6 +617,9 @@ public final class ActivityThread {
 
         // we use token to identify this activity without having to send the
         // activity itself back to the activity manager. (matters more with ipc)
+        //
+        // created by Smaster / twenty-two;
+        // sendMessage --> 发送一个消息给H处理。 --> Handler　中　H
         public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
                 ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
                 IVoiceInteractor voiceInteractor, int procState, Bundle state,
@@ -1158,6 +1175,11 @@ public final class ActivityThread {
         }
     }
 
+    /**
+     * created by Smaster / twenty-three;
+     *  对消息的处理；　LAUNCH_ACTIVITY ;
+     *
+     * */
     private class H extends Handler {
         public static final int LAUNCH_ACTIVITY         = 100;
         public static final int PAUSE_ACTIVITY          = 101;
@@ -1266,6 +1288,12 @@ public final class ActivityThread {
             }
             return Integer.toString(code);
         }
+
+        /**
+         * created by Smaster / twenty-four;
+         *  handleMessage(r, null)方法实现；
+         *
+         * */
         public void handleMessage(Message msg) {
             if (DEBUG_MESSAGES) Slog.v(TAG, ">>> handling: " + codeToString(msg.what));
             switch (msg.what) {
@@ -2172,9 +2200,20 @@ public final class ActivityThread {
         sendMessage(H.CLEAN_UP_CONTEXT, cci);
     }
 
+    /**
+     * created by Smaster / twenty-six;
+     * 该方法最终完成activity的啓動；
+     * 主要完成六件事；
+     *
+     * . 
+     *
+     * */
     private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
         // System.out.println("##### [" + System.currentTimeMillis() + "] ActivityThread.performLaunchActivity(" + r + ")");
-
+        /**
+         *
+         * 1.从ActivityClientRecord中获取待启动的Activity的组件信息；
+         * */
         ActivityInfo aInfo = r.activityInfo;
         if (r.packageInfo == null) {
             r.packageInfo = getPackageInfo(aInfo.applicationInfo, r.compatInfo,
@@ -2195,6 +2234,10 @@ public final class ActivityThread {
 
         Activity activity = null;
         try {
+            /**
+             * 2. 通过Instrumention的newActivity方法使用类加载器创建Activity对象；
+             *
+             * */
             java.lang.ClassLoader cl = r.packageInfo.getClassLoader();
             activity = mInstrumentation.newActivity(
                     cl, component.getClassName(), r.intent);
@@ -2213,6 +2256,11 @@ public final class ActivityThread {
         }
 
         try {
+
+            /**
+             * 3. 创建Application 对象；
+             *
+             * */
             Application app = r.packageInfo.makeApplication(false, mInstrumentation);
 
             if (localLOGV) Slog.v(TAG, "Performing launch of " + r);
@@ -2224,6 +2272,12 @@ public final class ActivityThread {
                     + ", dir=" + r.packageInfo.getAppDir());
 
             if (activity != null) {
+                /**
+                 * 4. 创建ContextImpl 对象并通过Activity的attach方法来完成一些重要数据的初始化；
+                 * 　Context的逻辑都是由ContexImpl来完成的。
+                 * 　ContextImpl是通过activity的attach方法来和activity建立关联。
+                 * 　
+                 * */
                 Context appContext = createBaseContextForActivity(r, activity);
                 CharSequence title = r.activityInfo.loadLabel(appContext.getPackageManager());
                 Configuration config = new Configuration(mCompatConfiguration);
@@ -2248,6 +2302,9 @@ public final class ActivityThread {
                 if (r.isPersistable()) {
                     mInstrumentation.callActivityOnCreate(activity, r.state, r.persistentState);
                 } else {
+                    /**
+                     * 5. finished;i成
+                     * */
                     mInstrumentation.callActivityOnCreate(activity, r.state);
                 }
                 if (!activity.mCalled) {
@@ -2340,6 +2397,10 @@ public final class ActivityThread {
         return baseContext;
     }
 
+    /**
+     * created by Smaster / twenty-five;
+     * ---> performLaunchActivity
+     * */
     private void handleLaunchActivity(ActivityClientRecord r, Intent customIntent) {
         // If we are getting ready to gc after going to the background, well
         // we are back active so skip it.
diff --git a/core/java/android/app/ApplicationThreadNative.java b/core/java/android/app/ApplicationThreadNative.java
index 0123e16..544c00d 100644
--- a/core/java/android/app/ApplicationThreadNative.java
+++ b/core/java/android/app/ApplicationThreadNative.java
@@ -678,6 +678,13 @@ public abstract class ApplicationThreadNative extends Binder
     }
 }
 
+/**
+ * created by Smaster / twenty;
+ *  系统AIDL / 
+ *  ApplicationThreadNative 是 IApplicationThread　的实现者。
+ *  由于ApplicationThreadNative被定义为抽象类，　所以ApplicationThread就成
+ *  了IApplicationThread的最终实现者。
+ * */
 class ApplicationThreadProxy implements IApplicationThread {
     private final IBinder mRemote;
     
diff --git a/core/java/android/app/IApplicationThread.java b/core/java/android/app/IApplicationThread.java
index f53075c..226fe31 100644
--- a/core/java/android/app/IApplicationThread.java
+++ b/core/java/android/app/IApplicationThread.java
@@ -47,6 +47,14 @@ import java.util.Map;
  *
  * {@hide}
  */
+
+/**
+ * created by Smaster / eighteen;
+ *  继承IInterface接口，所以它是　Binder 类型的接口。
+ *　包含大量启动　/ 停止　/ Activity的接口。　和　停止　/ 启动　服务的接口；
+
+ *   IApplicationThread 中的实现　---> 　ActivityThread中内部类　ApplicationThread.
+ * */
 public interface IApplicationThread extends IInterface {
     void schedulePauseActivity(IBinder token, boolean finished, boolean userLeaving,
             int configChanges, boolean dontReport) throws RemoteException;
diff --git a/core/java/android/app/Instrumentation.java b/core/java/android/app/Instrumentation.java
index 60a013e..228f982 100644
--- a/core/java/android/app/Instrumentation.java
+++ b/core/java/android/app/Instrumentation.java
@@ -1482,6 +1482,10 @@ public class Instrumentation {
                         intent.resolveTypeIfNeeded(who.getContentResolver()),
                         token, target != null ? target.mEmbeddedID : null,
                         requestCode, 0, null, options);
+            /**
+             * created by Smaster / five;
+             *  检查activity的启动结果
+             * */
             checkStartActivityResult(result, intent);
         } catch (RemoteException e) {
         }
@@ -1632,6 +1636,13 @@ public class Instrumentation {
      *
      * {@hide}
      */
+    /**
+     * created by Smaster / two;
+     *  ---> ActivityManagerNative.getDefault().startActivityAsUser();
+     *  AMS中实现；
+     *　AMS 继承　AMN , AMN继承Binder 并实现IActivityManager.
+     *  因此，AMS也是一个Binder, 它是IActivityManager的具体实现。
+     * */
     public ActivityResult execStartActivity(
             Context who, IBinder contextThread, IBinder token, Activity target,
             Intent intent, int requestCode, Bundle options, UserHandle user) {
@@ -1749,6 +1760,11 @@ public class Instrumentation {
     }
 
     /** @hide */
+    /**
+     * creatd by Smaster / six;
+     *  当无法正确启动一个Activity时，这个方法会抛出一个异常信息；
+     *　当待启动的Activity没有在AndroidManifest中注册时，　会抛出这个异常；
+     * */
     public static void checkStartActivityResult(int res, Object intent) {
         if (res >= ActivityManager.START_SUCCESS) {
             return;
diff --git a/services/core/java/com/android/server/am/ActivityManagerService.java b/services/core/java/com/android/server/am/ActivityManagerService.java
index 8dfb321..a20d5c3 100755
--- a/services/core/java/com/android/server/am/ActivityManagerService.java
+++ b/services/core/java/com/android/server/am/ActivityManagerService.java
@@ -3535,7 +3535,11 @@ public final class ActivityManagerService extends ActivityManagerNative
         }
         mProcessObservers.finishBroadcast();
     }
-
+    
+    /**
+     * created by Smaster / seven;
+     *
+     * */
     @Override
     public final int startActivity(IApplicationThread caller, String callingPackage,
             Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode,
@@ -3545,6 +3549,10 @@ public final class ActivityManagerService extends ActivityManagerNative
             UserHandle.getCallingUserId());
     }
 
+    /**
+     * creatd by Smaster / eight;
+     * --> ActivityStackSupervisor startactivityMayWait方法；
+     * */
     @Override
     public final int startActivityAsUser(IApplicationThread caller, String callingPackage,
             Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode,
diff --git a/services/core/java/com/android/server/am/ActivityStack.java b/services/core/java/com/android/server/am/ActivityStack.java
index e1b8278..dbe3249 100755
--- a/services/core/java/com/android/server/am/ActivityStack.java
+++ b/services/core/java/com/android/server/am/ActivityStack.java
@@ -1467,6 +1467,11 @@ final class ActivityStack {
         return resumeTopActivityLocked(prev, null);
     }
 
+    /**
+     * created by Smaster / thirteen;
+     *   --> resumeTopActivityInnerLocked
+     *
+     * */
     final boolean resumeTopActivityLocked(ActivityRecord prev, Bundle options) {
         if (inResumeTopActivity) {
             // Don't even start recursing.
@@ -1483,7 +1488,12 @@ final class ActivityStack {
         }
         return result;
     }
-
+    
+    /**
+     * creatd by Smaster / fourteen;
+     *   --> ActivityStackSupervisor  startSpecificActivityLocked方法
+     *
+     * */
     final boolean resumeTopActivityInnerLocked(ActivityRecord prev, Bundle options) {
         if (ActivityManagerService.DEBUG_LOCKSCREEN) mService.logLockScreen("");
 
diff --git a/services/core/java/com/android/server/am/ActivityStackSupervisor.java b/services/core/java/com/android/server/am/ActivityStackSupervisor.java
index 03dd3c0..e3c7ecb 100644
--- a/services/core/java/com/android/server/am/ActivityStackSupervisor.java
+++ b/services/core/java/com/android/server/am/ActivityStackSupervisor.java
@@ -810,6 +810,11 @@ public final class ActivityStackSupervisor implements DisplayListener {
                 0, 0, 0, null, false, null, null, null);
     }
 
+    /**
+     * created by Smaster / nine;
+     *  --> startActivityLocked;
+     * */
+
     final int startActivityMayWait(IApplicationThread caller, int callingUid,
             String callingPackage, Intent intent, String resolvedType,
             IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor,
@@ -1058,6 +1063,10 @@ public final class ActivityStackSupervisor implements DisplayListener {
         return ActivityManager.START_SUCCESS;
     }
 
+    /**
+     * created by Smaster / sixteen;
+     *  
+     * */
     final boolean realStartActivityLocked(ActivityRecord r,
             ProcessRecord app, boolean andResume, boolean checkConfig)
             throws RemoteException {
@@ -1154,6 +1163,25 @@ public final class ActivityStackSupervisor implements DisplayListener {
                     ? new ProfilerInfo(profileFile, profileFd, mService.mSamplingInterval,
                     mService.mAutoStopProfiler) : null;
             app.forceProcessStateUpTo(ActivityManager.PROCESS_STATE_TOP);
+            /* created by Smaster / seventeen;
+             *　总结: 
+             *       startActivityMayWait
+             *             |
+             *       startActivityLocked
+             *             |
+             *       startActivityUncheckedLocked    ---> resumeTopActivitiesLocked
+             *             | 
+             *       startSpecificActivityLocked     <--- resumeTopActivitiesLocked
+             *             |
+             *       realStartActivityLocked              ActivityStack;
+             *
+             *        ActivityStackSupervisor;
+             *
+             *
+             *
+             *        app.thread的类型为IApplicationThread
+             *
+             * **/
             app.thread.scheduleLaunchActivity(new Intent(r.intent), r.appToken,
                     System.identityHashCode(r), r.info, new Configuration(mService.mConfiguration),
                     r.compat, r.task.voiceInteractor, app.repProcState, r.icicle, r.persistentState,
@@ -1235,6 +1263,10 @@ public final class ActivityStackSupervisor implements DisplayListener {
         return true;
     }
 
+    /**
+     * created by Smaster / fifteen;
+     *  -- > realStartActivityLocked;
+     * */
     void startSpecificActivityLocked(ActivityRecord r,
             boolean andResume, boolean checkConfig) {
         // Is this activity's application already running?
@@ -1269,6 +1301,11 @@ public final class ActivityStackSupervisor implements DisplayListener {
                 "activity", r.intent.getComponent(), false, false, true);
     }
 
+    /**
+     * created by Smaster / ten ;
+     *  --> startActivityUncheckedLocked方法；
+     *
+     * */
     final int startActivityLocked(IApplicationThread caller,
             Intent intent, String resolvedType, ActivityInfo aInfo,
             IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor,
@@ -1570,7 +1607,12 @@ public final class ActivityStackSupervisor implements DisplayListener {
             moveHomeStack(isHomeActivity);
         }
     }
-
+　　/**
+    *created by Smaster / eleven;
+    * 
+    * ---> resumeTopActivitiesLocked();
+    *
+    */　
     final int startActivityUncheckedLocked(ActivityRecord r, ActivityRecord sourceRecord,
             IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor, int startFlags,
             boolean doResume, Bundle options, TaskRecord inTask) {
@@ -2417,7 +2459,12 @@ public final class ActivityStackSupervisor implements DisplayListener {
     boolean resumeTopActivitiesLocked() {
         return resumeTopActivitiesLocked(null, null, null);
     }
-
+    
+    /**
+     * created by Smaster / twelve;
+     *  ---> ActivityStack　resumeTopActivityLocked;
+     *
+     * */
     boolean resumeTopActivitiesLocked(ActivityStack targetStack, ActivityRecord target,
             Bundle targetOptions) {
         if (targetStack == null) {
-- 
```
**我会逐渐增加注释**
