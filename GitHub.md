# Version Control System, Git & GitHub

## Why do we need Version Control System?
1. How do you collaborate? work as a team?
2. How to trace / track / restore / merge changes and versions?
3. How to govern / secure / manage the source code / documents?

## Why Git & GitHub?

* Git is the most popular and wide-used version control system (VCS) today. It was created by Linus Torvalds (The father of Linux).

* GitHub is an internet hosting service for git repositories. Public repos are free; private repos are paid. As a shared space for repos, it allows you to do collaborative work.

* Git is the VCS used to use GitHub, GitLab, AliyunCode etc.
* Now Github is part of your credentials - a measure of your coding abilities and skills.

## VCS history - Git vs SVN vs Clearcase
https://trends.google.com/trends/explore?date=2004-03-19%202020-04-19&geo=US&q=%2Fm%2F05vqwg,%2Fm%2F012ct9,%2Fm%2F01ybz2

![Git-SVN-ClearCase](./resources/Git-SVN-Clearcase.jpg)

## Create a GitHub Account 

1. got to https://github.com/ click sign up
2. enter username, email, password. 

## Create a Git Repository 

1. got to https://github.com/ click `new`, or go to https://github.com/new 
2. enter repos name, e.g. `myproject`
3. choose public vs private (for class projects, choose private)

## Collaborate a project with others

For a group project, the project owner needs to add collaborators (group members) in the project:
1. Settings -> Manage access -> Click on `Invite a collaborator` 
2. enter collaborator's email or user name. An email invite is sent to the collaborator
3. the collaborator needs to click on link in the email to accept the invite. 
4. repeat above steps for all collaborators
Now all collaborators cannot contribute to the projects.

## Github Code Deliveries 

Github supports multiple protocols for connecting to a repository.

1. HTTPS: https://github.com/mkz100/JavaClass.git (use basic auth - username / password)
2. SSH (Secure Shell) : git@github.com:mkz100/JavaClass.git (use private / public keys) 
3. CLI : Github command line interface
4. Github Desktop: a separate utility to manage code deliveries.

SSH is recommended for most use cases. It is secure and simple for cli as well as IDEs.

## [Optional] Set up SSH 
SSH or Secure Shell is a network communication protocol that enables two computers to communicate and share data thru Public key infrastructure (PKI).

### Understand the basics of PKI
Public-Private key encryption:
![ssh](resources/ssh.jpg)

https://docs.github.com/en/github/authenticating-to-github/connecting-to-github-with-ssh

### Benefits for using SSH

Using the SSH protocol, you can connect and authenticate to remote servers and services. With SSH keys, you can connect to GitHub without supplying your username and personal access token at `each visit`.

### Generate SSH key pair

https://docs.github.com/en/github/authenticating-to-github/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent

### Adding a new SSH key to your GitHub account

https://docs.github.com/en/github/authenticating-to-github/adding-a-new-ssh-key-to-your-github-account




