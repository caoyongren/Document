## Git的基本使用
***
*Git 项目的三个工作区域的概念:Git 仓库、工作目录以及暂存区域.*
#### Linux上安装
```
sudo apt install git
```
#### git前配置
*Git 自带一个 git config的工具来帮助设置控制git外观和行为的配置变量.*

  - /etc/gitconfig 文件: 包含系统上每一个用户及他们仓库的通用配置。 如果使用带有 --system 选项的
git config 时,它会从此文件读写配置变量

  - ~/.gitconfig 或 ~/.config/git/config 文件:只针对当前用户。 可以传递 --global 选项让 Git
读写此文件。

  - 当前使用仓库的 Git 目录中的 config 文件(就是 .git/config):针对该仓库。

#### 用户信息
```
git config --global user.name "name"
git config --global user.email "163.com"

# 查看
git config --list
# 查看名字
git config user.name
```
#### 初始化仓库
```
git init
```
#### 克隆仓库
```
git clone https://github.com/caoyongren/MatthewFileM.git
```
#### 查看当前文件的状态
```
git status
# 简化的查看
git status -s
```
#### 忽略文件
```
vim .gitignore
```

#### 查看修改的部分
```
git diff
# 和暂存区区域之间的差异
git diff --cached
```
#### 提交更新
```
git commit -a -m ""

# 严谨
git commit -a -s
```
#### 查看提交历史
```
git log
# 按补丁格式显示每个更新之间的差异
git log -p commitId
# 显示每次更新的文件修改统计信息
git log --stat commitId
# 仅在提交信息后显示已修改的文件清单
git log --name-only
# 显示新增、修改、删除的文件清单
git log --name-status
# 显示 ASCII 图形表示的分支合并历史
git log --graph
# 时间段 
git log --since "2008-10-01"
git log --after "2008-10-11"
# 检索
git log --grep ""
# 作者
git log --author
# 输出你的提交历史、各个分支的指向以及项目的分支分叉情况
git log --oneline --decorate --graph --all
# 查看head的历史
git reflog
```
#### 撤销操作
```
# 例如忘记添加文件
git commit --amend
# 单个文件修改
git checkout file
```
#### 查看远程仓库
```
git remote -v
```
#### 添加远程仓库
```
git remote add origin git@github.com:git_username/repository_name.git
```
#### 取消本地目录下关联的远程库
```
git remote remove origin
```
#### 拉取信息
```
git fetch origin
# 应用将服务器的改动--> 本地dev
git merge branch(需要合并的master分之)

# 本地操作
git merge dev(在master分之，合并dev修改的文件)
# 解决冲突
>>>>>  <<<<
```
#### 建立在远程跟踪分支之
```
git checkout -b serverfix origin/serverfix
＃　另一种关联
git checkout remote_branch -b local_branch
```
#### 分之的操作
```
# 查看分之
git branch
# 新建分之
git checkout -b dev
# 切换分之
git checkout master
# 删除分之
git checkout -D dev
# 查看所有分之
git branch -a
# 查看分之节点信息
git branch -v
# 查看分之的最近提交信息
git show-branch (--more=10 表示显示10条)
```
#### 推送数据
```
# githup
git push -u origin master
# 工作
git push origin 本地分之:远程分之
```
#### 打补丁
```
#给当前提交打补丁
git format-patch HEAD^
# 获得最近n次提交的补丁
git format-patch -n
# 应用补丁(并不提交)
git apply 001-patch
# 直接提交补丁
git am 001-patch
```
#### git am 001-patch 冲突解决
```
git am 001-patch --rej
# 然后手动解决
```

#### 安装gitk图形化commitId

#### git pull 就是从服务器拉取数据然后直接合并。

#### 撤销操作
```
# 回退commitId版本(切换到commitId版本)
git reset --hard commitId
# 修改提交
git commit --amend
```
#### 创建tag
```
# 查看tag list
git tag
# 创建tag
git tag -a v1.4 -m 'my version 1.4'
# 查看某个tag
git show v1.4
# 轻量级标签:
git tag v1.4-1w
# 推送标签到服务器
git push origin v1.5
```
#### 通过githup进行团队协作的使用
  - 将派生出的副本克隆到本地
  - 创建出名称有意义的分支
  - 修改代码
  - 检查改动
  - 将改动提交到分支中
  - 将新分支推送到 GitHub 的副本中.
***