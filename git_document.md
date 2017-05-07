1. 安装 ～

2. git init ； 初始化

3. git add file1 file2

4. git diff --cached

5. git status ; 获得当前一个状态

6. git commit -a -s ; 提交 并写补丁描述

7. git branch multiwindow ； 创建分之

8. git checkout openthos ;切换分之

9. 当在multiwindow  / openthos 中做了不同的修改
   进行合并分支--> multiwindow：
   git merge multiwindow 

10. 如果出现冲突
  git diff  查看

11. 编辑
   git commit -a -s ;提交

12. gitk 可视图的查看

13. git branch -D openthos ; 删除分支

14. 撤销一个提交
  git reset --hard HEAD

15. git log 查看日志

16. 找出v2.5开始在fs 目录下的Makefile所有修改
  git log v2.5.. Makefile fs/

17. git log -p 显示补丁内容

18. git log --state //日志统计

19. git log --pretty=oneline  //规整日志

20.  git log --pretty=format:'%h : %s' --graph  //同上

21.  git log --pretty=format:'%h : %s' --topo-order --graph //有点复杂

22. git diff master test //比较项目中两个版本的差异（分支）

23. git diff HEAD //和上次提交的差异

24. git diff HEAD -- ./lib   //做一个缩小范围到文件夹

***

#### 分布式工作流
25. git clone /home/matthew/project myrepo //建一个myrepo clone 工程

26. git pull /home/matthew/project master //将修改拉下啦

解释： git pull命令执行两个操作: 它从远程分支(remote branch)抓取修改 的内容，然后把它合并进当前的分支。

27. $ git remote add bob /home/bob/myrepo  //将缩写-- > bob 表示/home/bob/murepo

28. 情况；
  如果修改了同一个文件
解决：
  git fetch bob  // 先获取 但是不合并

  git log -p master ..bob/master  //显示修改的内容 -- > 手动解决

  git merge  bog/master ;将手动解决冲突的修改 合并到主分支

  git pull ../reset/bob/master //合并

                        you push
                          your personal repo ------------------> your public repo
                              ^                                     |
                              |                                     |
                              | you pull                            | they pull
                              |                                     |
                              |                                     |
                              |               they push             V
                          their public repo <------------------- their repo
#### 将修改推到一个公共仓库

29. git push ssh:~  .git master:master

30. git push public-repo master //简化

31. git tag stable-l 1b2edfadsfa //指定某个提交，方便根基标签查看和回顾

32. git rebase
  - git  checkout myWork (自己分支)
  - git rebase origin 
  - 目的： 把你的分支 myWork 取消掉，并且把它们临时保存为补丁放到 .git/rebase目录中，然后把myWork分支更新到最新的origin分支，最后把保存的补丁apply到 myWork分支上。

33. 在git rebase 过程中，也许会出现冲突， 在这种情况，git 会停止rebase并会让你去解决冲突； 解决后，用 git-add 命令更新，不需要git-commit;
  git rebase --continue //继续应用余下的补丁。

34. git rebase --abort // 终止 rebase 的行动。

35. 
