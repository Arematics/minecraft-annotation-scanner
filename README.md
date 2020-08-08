# Support and updates for this library ended.
# minecraft-annotation-scanner
Scans for Annotations in Modules so no self registration of Listeners and Commands is now longer needed

### This plugin should be started first.

## Build

To build this project you must clone it and add an **new folder Libs**, 
there you need to add your Spigot **as SpigotServer.jar**.

After this start **gradlew jar** or **gradlew publishToMavenLocal**

## Usage

Then you could run these lines later in all other projects by replacing "my.package.name" with your project package. The **bootstrap** needs to be your JavaPlugin Class where Listeners and Commands should be added.
```
String url ="my.package.name";
CommandHooks.hookCommands(url, this.getClass().getClassLoader(), bootstrap);
ListenerHook.hookListeners(url, this.getClass().getClassLoader(), bootstrap);
```

Thats all, all classes with the **@EventHandler** Annotation on a method and all Commands extending the **CoreCommand** 
and having the **@Command** Annotation are registered as Listeners and Commands
