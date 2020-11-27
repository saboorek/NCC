name: NeptuneCraftCore
version: Beta 1.0 
author: Saboorek
main: me.saboorek.neptunecore.Main

commands:
  ulecz:
    description: Komenda do leczenia sie
    aliases: [lecz, heal]
  pogoda:
    description: Komenda do zmiany pogody
    aliases: [weather]
  gm:
    description: Komenda do zmiany gamemode
  mspawn:
    description: komenda uzywana do spawnu potworow
  aduty:
    description: komenda administracyjna sluzaca do rozpoczynania pracy admina
  config:
    description: komenda uzywana do aktualizacji configu
  spawn:
    description: komenda odpowiedzialna za teleportacje na spawn
  automsg:
    description: komenda administracyjna sluzaca do zarzadzania autoMSG
  report:
    description: komenda sluzaca do zglaszania bledow oraz graczy lamiacych regulamin
  getpos: 
  ck:
permissions:
  ncc.*:
    default: op
    children:
      ncc.admin.weather: true
      ncc.admin.gamemode: true
      ncc.heal: true
      ncc.mobspawn: true
      ncc.spawn: true
      ncc.config: true
      ncc.automsgs: true

