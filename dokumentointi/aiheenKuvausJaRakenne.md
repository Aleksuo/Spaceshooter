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

**Osa 1:**
App sisältää luokat StateManager, KeyManager ja Window. KeyManager on KeyListener rajapintaa toteuttava luokka joka liitetään Window-luokan JFrameen. KeyManager pitää boolean-taulukossa jokaisen näppäimen nykyisen tilan. Window-luokka pitää sisällään JFramen ja siihen liitetyn Canvasin jolle kaikki sovelluksen piirtäminen tapahtuu. StateManager-luokka vastaa sovelluksen nykyisen tilan vaihdosta ja käsittelystä. MenuState-luokka on tila johon sovellus käynnistyy ensimmäisenä ja pysyy tilapinon pohjalla kunnes sovellus suljetaan. GameplayState on tila jossa peli tapahtuu. ResultState tulee GameplayStaten jälkeen, jolloin näytetään pelaajan saavuttama pistemäärä.

![luokkakaavio osa1](/dokumentointi/luokkakaavio1.png)

**Osa 2:**
LevelManager on siis GameplayStaten sisällä. LevelManager hallinnoi tasoihin liittyviä tapahtumia. Se sisältää MinimiKeon komennoista, jotka on järjestetty suoritusajan mukaan.Tällä hetkellä komentoja tosin on vaan yksi: SpawnEnemyCommand, joka pitää sisällään tiedot siitä minne,milloin ja mikä vihollinen ilmentyy tasoon. LevelLoader-luokan avulla LevelManager lataa komennot tekstitiedostoista. SpawnManagerin avulla SpawnEnemyCommandit muunnetaan ilmentymiksi tasoon. SpawnManager sisältää Spawnereita, jotka luovat ilmentymiä niihin määriteltyjen vihollisprototyyppien mukaan. Kulunut aika lasketaan Timer-luokan avulla. Level-luokka pitää sisällään luokkiin liittyvän datan ja pitää kirjaa pisteistä Scorecounter-luokan avulla.

Objektihierarkiassa alimpana on abstrakti GameObject-luokka, joka sisältää objektien perustoiminnallisuuden. Abstraktiluokka ImageObject lisää objekteihin mahdollisuuden kuvaan. Player-luokka sisältää pelaajan alukseen liittyvän toiminnallisuuden. Player-luokalla on jokin ase(Weapon) ja erikoistaito(Special). Enemy on abstraktiluokka joka sisältää vihollisiin liittyvän perustoiminnallisuuden. Mine-luokka on vihollinen joka pyrkii seuraamaan pelaajaa. Saucer-luokka on vihollinen jolla on ase, joka ampuu pelaajaa kohti ja liikkuu aaltomaisesti. 
 
Projectile-luokat ovat pelaajan ja vihollisten ammuksia joita Weapon-luokat ilmennyttävät tasoon. Shield on erikoistaidon ShieldSpecial tuottama objekti, joka tekee objektista tuhoutumattoman joksikin aikaa. Weapon-luokat ja Special luokat ajastavat käyttökertojen välissä olevan ajan Timer-luokan avulla. Pickup-luokat ovat objekteja joihin törmätessään pelaaja saa päivityksiä aseeseensa tai latauksen erikoistaitoonsa.

![luokkakaavio osa2](/dokumentointi/luokkakaavio2.png)
![Poimiminen](/dokumentointi/poimiminen.png)
![Viholliseen törmäys](/dokumentointi/viholliseentormays.png)
