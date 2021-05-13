# Git commands

https://dzone.com/articles/top-20-git-commands-with-examples

## clone a repository
```
git clone git@github.com:mkz100/JavaClass.git
```

## create a new repository on the command line
```
echo "# JavaClass" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin git@github.com:mkz100/JavaClass.git
git push 

```
## push an existing repository from the command line
```
git remote add origin git@github.com:mkz100/JavaClass.git
git push 
```

## Git config
```
cat .git/config
[core]
        repositoryformatversion = 0
        filemode = true
        logallrefupdates = true
        precomposeunicode = true
[remote "origin"]
        url = git@github.com:mkz100/JavaClass.git
        fetch = +refs/heads/*:refs/remotes/origin/*
[branch "master"]
        remote = origin
        merge = refs/heads/master
        rebase = false
```

## 