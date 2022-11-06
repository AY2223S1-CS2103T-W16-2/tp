---
layout: ppp
title: Mai Ting Kai's Project Portfolio Page
---

<!-- markdownlint-disable-next-line blanks-around-headers -->
### Project: FoodRem
{: .no_toc}

<!-- markdownlint-disable-next-line proper-names -->
{{ site.data.foodrem.about.summary }}

Given below are my contributions to the project.

* **New Feature**: Added the ability to undo/redo previous commands.

  * What it does: allows the user to undo all previous commands one at a time. Preceding undo commands can be reversed by using the redo command.
  * Justification: This feature improves the product significantly because a user can make mistakes in commands and the app should provide a convenient way to rectify them.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
  * Credits: _{mention here if you reused any code/ideas from elsewhere or if a third-party library is heavily used in the feature so that a reader can make a more accurate judgement of how much effort went into the feature}_

* **New Feature**: Added a history command that allows the user to navigate to previous commands using up/down keys.

* **Code contributed**: [RepoSense link]()

* **Project management**:

  * Managed releases `v1.3` - `v1.5rc` (3 releases) on GitHub

* **Enhancements to existing features**:

  * Updated the GUI color scheme (Pull requests [\#33](), [\#34]())
  * Wrote additional tests for existing features to increase coverage from 88% to 92% (Pull requests [\#36](), [\#38]())

* **Documentation**:

  * User Guide:
    * Added documentation for the features `delete` and `find` [\#72]()
    * Did cosmetic tweaks to existing documentation of features `clear`, `exit`: [\#74]()
  * Developer Guide:
    * Added implementation details of the `delete` feature.

* **Community**:

  * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
  * Contributed to forum discussions (examples: [1](), [2](), [3](), [4]())
  * Reported bugs and suggestions for other teams in the class (examples: [1](), [2](), [3]())
  * Some parts of the history feature I added was adopted by several other class mates ([1](), [2]())

* **Tools**:
  * Integrated a third party library (Natty) to the project ([\#42]())
  * Integrated a new Github plugin (CircleCI) to the team repo
* \_{you can add/remove categories in the list above}

* **PRs**:
  * Add PPP skeleton ([[PR#64]])
  * Add profile picture ([[PR#67]])
  * Add User Guide section ([[PR#82]])
  * Rename ferusel.jpg to ferusel.png ([[PR#85]])
  * Add Glossary, UC3, UC4 to Developer Guide ([[PR#87]])
  * Add Ting Kai information to AboutUs ([[PR#98]])
  * Add Item model ([[PR#143]])
  * Add Item Unit Tests ([[PR#155]])
  * Add Sort Command ([[PR#158]])
  * Add Increment and Decrement Command ([[PR#161]])
  * Add Acknowledgements section to User Guide ([[PR#162]])
  * Add Glossary section to User Guide ([[PR#163]])
  * Add Glossary section to Developer Guide ([[PR#164]])
  * Add View command ([[PR#209]])
  * Add Sorting user stories to DG ([[PR#210]])
  * Add Sort Command UML ([[PR#232]])
  * Update UG with v1.3 Features ([[PR#258]])
  * Consolidate UG v1.3 ([[PR#264]])
  * Update Developer Guide with v1.3  ([[PR#295]])
  * Update README with v1.3 items ([[PR#311]])
  * Update UG after Refactoring ([[PR#318]])
  * Fix find command description in Command Summary ([[PR#324]])
  * Improve UG for v1.3 ([[PR#335]])
  * Fix UG after Peer Review ([[PR#351]])
  * Add Statistics Command ([[PR#360]])
  * Update find command ([[PR#367]])
  * Website Hot Fix ([[PR#369]])
  * Fix stats command ([[PR#372]])
