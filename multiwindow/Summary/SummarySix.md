### Rxjava  --> 简书，　　只是看了一部分　　还需要再研究．

### 关于Sleep 的代码
  - 38f8716ed2351f52a1727c4226bda3f8255eb59d 　-- Do not automatically sleep.

### 关于通知栏的Clear all
  - 35bed08e11df40efbc8d74cbec08f5dd56654e66  -- 通知栏上的clear all.

### 关于lock without password.
  - a52256d28080c32075306b46833a0c7e970b3755  --

### alt + tab  -- > 切换导致　任务栏隐藏　　-- > ActivityStackSuper.java


### init config   -- > OpenthosIDSetupActivity.java


### ActivityManagerService.java   -- >  closeActivity    finish();


### 16ac66720e0633cfef816a851b4fd7864d360f70
   - frameworks: base: Support: Notification icon changes hightlight when receives a notification


### 5.0 以后谷歌不建议隐式启动activity.
  - 显示启动：
    - ComponentName compoment = new ComponentName(package, className);
    - Intent intent = new Intent();
    
###  获取栈顶的Activity
  - ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
  - String topActivity = activityManager.getRunningTasks(1).get(0).topActivity;
  
### SystemUIApplication    强制设置　　语言　配置文件．

### onConfigurationChanged    -- >  设置就会执行该方法．例如：　语言改变执行．

### 关闭界面的移动focus.
  - ce29490009ca68667c48b89750e967970fcbffdd

### git rebase 和 git merge 区别
  - git merge 是用来合并两个分之的．
    - git merge b
      - 将ｂ分之合并到当前分之．

  - git rebase b
   - 也是把ｂ分之合并到当前分支．

案例：

        origin

  c1<-- c2 

        myWork

然后，有人在origin上做了提交，　myWork也做了提交

                       origin

c1 <-- c2 < ---c3 <--- C4

               C5 <----C6
                        myWork

你可以git pull把origin上修改的的code拉下来，　然后　git merge.

                        origin

c1 <-- c2 < -- c3 < --- c4

       c2< --  c5 < --- c6< --- c7

                                myWork

但是，提交历史记录发生改变，如果要想保持和origin一样的提交历史：

　　- git checkout myWork
    - git rebase origin

原理：
　　- 把你的myWork分支里的每个提交取消掉，并且临时保存为补丁，
　　- ./git/rebase目录中，　然后再应用上．

    

### 解决冲突
  - git-add
  - git rebase --continue

















 
