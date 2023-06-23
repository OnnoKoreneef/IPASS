async function getKlant(email) {
    const url = `http://localhost:8080/restservices/klanten/${email}`
    return fetch(url).then((response) => response.json());
}

async function laadGegevens(email) {
    try {
        const klant = await getKlant(email);
        console.log(klant);
        const voornaam = klant.voornaam;
        const achternaam = klant.achternaam;
        const email = klant.email;
        const woonplaats = klant.woonplaats;
        const straatnaam = klant.straatnaam;
        const nummer = klant.huisnummer;
        const telefoonnummer = klant.telefoonnummer;

        document.getElementById("voornaam").innerHTML = voornaam;
        document.getElementById("achternaam").innerHTML = achternaam;
        document.getElementById("email").innerHTML = email;
        document.getElementById("woonplaats").innerHTML = woonplaats;
        document.getElementById("straatnaam").innerHTML = straatnaam;
        document.getElementById("huisnummer").innerHTML = nummer;
        document.getElementById("telefoonnummer").innerHTML = telefoonnummer
    } catch (Exception) {
        console.log("no data");
    }
}