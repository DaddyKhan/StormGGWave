# StormGGWave
StormGGWave is a simple plugin that allows you to activate GG Waves of a certain duration on your server, whenever you'd like! This has been seen on servers when a player purchases something from their store.
The plugin is tested and working on the versions 1.8 - 1.16. It is possible that it may work on higher versions, however, it is untested.

# Commands
/ggwave start <duration> - Starts a GG Wave
/ggwave stop - Stops an active GG Wave
/ggwave reload - Reloads the configuration files

All GGWave commands require the permission 'ggwave.use'

# Config
<details>
  <summary>config.yml</summary>
  
  ```yaml
  settings:
    permission: "ggwave.use"
  ggwave-messages:
    - "&a&lGG"
    - "&b&lGG"
    - "&c&lGG"
    - "&d&lGG"
    - "&e&lGG"
    - "&f&lGG"
  messages:
    WAVE-START:
     - "&f&m--&e&lG&6&lG &e&lW&6&lA&e&lV&6&lE &e&lA&6&lC&e&lT&6&lI&e&lV&6&lA&e&lT&6&lE&e&lD&f&m--"
    WAVE-END:
     - "&f&m--&e&lTHE G&e&lG &e&lW&6&lA&e&lV&6&lE &e&lHAS ENDED!&f&m--"
    WAVE-ONGOING: "&a&l(!) &aYou cannot start a wave as there is already one ongoing!"
    WAVE-NOT-ONGOING: "&c&l(!) &cYou cannot end a wave as there is not one ongoing!"
    INVALID-DURATION: "&c&l(!) &cYou must specify a valid duration to start a GGWave!"
    NO-PERMISSION: "&c&l(!) &cYou do not have permission to execute that command!"
  ```
  
</details>
