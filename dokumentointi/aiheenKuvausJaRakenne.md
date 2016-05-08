**Aihe:** Shoot'em up -peli  <br />
Toteutetaan kaksiulotteinen  ylhäältäpäin kuvattu shoot'em up -peli. Pelaajan tarkoitus on ohjata avaruusalusta väistellen vihollisalusten ammuksia sekä samalla tuhota vihollisaluksia oman aluksensa aseella. Pelaaja aloittaa joka pelin kolmella vara-aluksella, joiden loppuessa myös peli loppuu. Vihollisalusten tuhoaminen kerryttää pelaajalle pisteitä ja oman aluksen tuhoutuminen puolestaan vähentää niitä. Pelaaja voi päivittää aluksensa asetta poimimalla asepäivityksiä. Pelaajan aluksella on erikoiskyky jonka voi aktivoida jos pelaajalla on siihen latauksia. Tuhoutuneet  viholliset voivat tiputtaa asepäivityksiä tai latauksia erikoiskykyyn.

**Käyttäjät:**Pelaaja

**Pelaajan toiminnot:**
  * Pelin aloittaminen
  * (Asetusten muokkaaminen)
  * Pelin sammuttaminen
  * (Pelin pysäyttäminen)
  * Aluksen liikuttaminen*
  * Aluksen aseen laukaiseminen*
  * Erikoiskyvyn käyttö*
    * onnistuu jos kykyyn on latauksia
  * Latauksien ja päivitysten poimiminen*
  * Aluksen tuhoutuminen.
  
*Pelaajalla tulee olla aluksia jäljellä ja pelin tulee olla aloitettu

Sovellus(App) sisältää tasomanagerin(LevelManager) joka tasonlataajan(LevelLoader) avulla lataa tekstitiedostosta listan tasoon liittyvistä komennoista(Commands). Tasomanageri jakaa komentojaan alimanagereilleen esim. vihollisten ilmentämiseen tarkoitetut SpawnEnemyCommandit menevät SpawnManagerille, joka ilmentää peliobjektin(GameObject) tasoon. 

![luokkakaavio osa1](/dokumentointi/luokkakaavio1.png)
![luokkakaavio osa2](/dokumentointi/luokkakaavio2.png)
![Poimiminen](/dokumentointi/poimiminen.png)
![Viholliseen törmäys](/dokumentointi/viholliseentormays.png)
