# MCReported

MCReported is a comprehensive Minecraft plugin designed to streamline the process of reporting players and bugs. It offers intuitive GUIs, Discord integration, and Bungeecord support, making it an essential tool for server administration.

## Features

- **User-Friendly GUIs**: Report players or bugs through intuitive graphical interfaces. ✅
- **Discord Integration**: Send reports directly to Discord channels. ✅
- **Customizable**: Tailor the plugin settings to fit your server needs. ✅
- **Bungeecord Interaction**: Compatible with Bungeecord networks. ✅
- **Multi-Version Support**: Works with multiple Minecraft versions. ✅
- **More Features Coming Soon**:
  - Additional GUIs for better management.
  - New commands for both Discord and Minecraft.
  - Report statistics and tracking.
  - Multi-language support.
  - Enhanced customization options.

## Commands

| Command                | Description                              | Permission         |
|------------------------|------------------------------------------|--------------------|
| `/report`              | Report a player or a bug.                | `MCreport.report`  |
| `/reports`             | Show all reports.                        | `MCreport.view`    |
| `/reloadrmcl`          | Reload the plugin configurations.        | `MCreport.admin`   |
| `/reportscancel <id>`  | Cancel a specific report.                | `MCreport.staff`   |
| `/reportscancelall`    | Cancel all reports.                      | `MCreport.staff`   |

### Permissions

| Permission            | Description                                  |
|-----------------------|----------------------------------------------|
| `MCreport.admin`      | Allows use of the `/reloadrmcl` command.     |
| `MCreport.staff`      | Allows use of all staff commands.            |
| `MCreport.report`     | Allows players to create reports.            |
| `MCreport.view`       | Allows staff to view all reports.            |

## Installation

1. **Download the Plugin**:
   - Get the latest version of `MCReported.jar` from the [Releases](https://github.com/zvicraft/MCreported/releases) page.

2. **Add to Plugins Folder**:
   - Place the `MCReported.jar` file into your server's `plugins` directory.

3. **Start the Server**:
   - Start or restart your server to generate the configuration files.

4. **Configure the Plugin**:
   - Open the `config.yml` file located in the `plugins/MCReported` folder.
   - Paste your Discord `TOKEN`, `PLAYER-CHANNEL`, and `BUGS-CHANNEL` IDs in the appropriate fields.

## Default Configuration (`config.yml`)

```yaml
config: 1.3
## created by zvicraft

# Moderation
language-file: "en_us" # The language file to use

# General
prefix: "&6&lMCREPORTED &7| "
none-player: "&cOnly a player can do that command."
none-target: "&cYou need to specify a player for this command."
none-need-args: "&7Too many arguments for this command."
none-alive: "&cThis player does not exist or is not online."
reload: "&aPlugin reloaded successfully."
player-same: "&cYou can't report yourself!"

# Error messages
MUST-BE-PLAYER-ERROR: "&cOnly players can execute this command!"

# Discord settings
#WEBHOOK_URL_PLAYER: "" # Player report webhook URL
#WEBHOOK_URL_BUGS: "" # Bug report webhook URL

# GUI Settings
ReportCMD: "/" # Command prefix for the plugin
Report-PLayer: "&bReport Player..."
Report-Close: "&cClose"
Report-Bugs: "&bReport Bugs..."
Report-Menu: "&a&lReport Menu"
Online-Players-Menu: "&aOnline Players"
Status-Online-Menu: "&7Status: &aOnline"
ReportType: "&cReport Type"

# Bungeecord Settings
Bungee: false
SERVAR_NAME: "" # Server name for Bungeecord

# Discord Bot Settings
TOKEN-INVADE: "ERROR: Provided bot token is invalid!"
TOKEN: "" # Discord bot token
PLAYER-CHANNEL: "" # Player report channel ID
BUGS-CHANNEL: "" # Bug report channel ID
WSH: "" # WebSocket URL
GILD-ID: "" # Guild ID
