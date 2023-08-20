# Project Management 

# Kanban

Kanban is an agile Lean workflow management method that helps organizations manage and improve work systems. Originating from manufacturing (Toyota in the 1950s), it later became a territory claimed by Agile software development teams.

The Japanese word “kanban” means “visual board” or a “sign”.

## Lean Principles

Lean manufacturing's core purpose is minimizing waste activities without sacrificing productivity. The main goal is to create more value for the customer without generating more costs.

## The Kanban Method

In the 21st century, Kanban started being applied in other sectors, such as IT and software development. The Kanban method was first defined in 2007.

### The Kanban Board

Kanban works with a Kanban board with three basic columns: "requested", "in progress" and "done". When constructed, managed, and functioning correctly, it serves as a real-time information repository, highlighting bottlenecks within the system and anything else that might interrupt smooth working practices.

### Kanban Cards

For this project Kanban cards are written in the form of User Stories if related to app features and not to documentation. I use the GIVEN/WHEN/THEN approach, which gives criteria for User Acceptance Tests.

### Kanban Principles

|Change Management Principles |Service Delivery Principles|
|-----------------------------|---------------------------|
|Start With What You Do Now |Focus on Customer’s Needs and Expectations|
|Agree to Pursue Incremental, Evolutionary Change |Manage the Work, Not the Workers|
|Encourage Acts of Leadership at All Levels|Regularly Review the Network of Services|

Also:

- **Visualize the workflow**
- **Limit Work in Progress** -> There must be a WIP limit. **For this project the WIP limit is 3**. I acknowledge that sometimes switching tasks may improve my productivity, however if a task stays in progress for too long I need to address the reason it is so. Am I blocked by the complexity of the task and do I need help? Am I postponing this task for any other reason? Is this task actually a bonus instead of a need? Any way, having a WIP limit helps me see this type of issue and address it.
- **Manage flow**
- **Make process policies explicit**
- **Feedback loops**

## Why Kanban and not another project management method?

Kanban is the agile method that is the most adapted to a solo project. Its board system allows me to keep track of the tasks completed and yet to fulfill and of my workflow.

# Management Tools

## Git
Git is a decentralized version control system. I use it on this project for the following reasons:
* I can use the system of branches to create and tests new features without threatening the code that works already.
* I can test if there are conflicts between existing features and a new one I'm creating.
* Previous versions of the code remain accessible as long as they have been committed.
* I keep track of my work and of my working process.

## GitHub

I use GitHub as a project management tool for the following reasons:
* It is a platform where I can store my code in a remote repository. If anything were to happen to my computer, my work would remain accessible to me.
* I can use it to show my code to my peers and get feedback.
* I use the projects section, where I created my Kanban board. It helps me manage my tasks and keep track of what I am currently working on.
* I use the wiki section to create and manage the project documentation.
* I link a commit to the related task issue by starting the commit message by the issue identifier. Exemple : git commit -m "#3 Added a form"
* GitHub pages are useful to see a demo of a web application.
