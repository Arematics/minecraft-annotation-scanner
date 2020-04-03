# minecraft-annotation-scanner
Scans for Annotations in Modules so no self registration of Listeners and Commands is now longer needed

### This plugin should be started first.

## Usage

Then you could run these lines later in all other projects by replacing "my.package.name" with your project package
```
String url ="my.package.name";
CommandHooks.hookCommands(url, this.getClass().getClassLoader(), bootstrap);
ListenerHook.hookListeners(url, this.getClass().getClassLoader(), bootstrap);
```

Thats all, all classes with the **@EventHandler** Annotation on a method and all Commands extending the **CoreCommand** 
and having the **@Command** Annotation are registered as Listeners and Commands
