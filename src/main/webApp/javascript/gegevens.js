const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const email = urlParams.get("email");

const klant = await getKlant(email);
const data = {
    voornaam: klant.voornaam,
    achternaam: klant.achternaam,
    emailKlant: klant.email,
    woonplaats: klant.woonplaats,
    straatnaam: klant.straatnaam,
    huisNummer: klant.huisNummer,
    telefoonnummer: klant.telefoonnummer,
    afspraken: klant.afspraken,
}

const dateFormatter = new Intl.DateTimeFormat("en-GB", {
    day: "2-digit",
    month: "long",
    year: "numeric"
})
const timeFormatter = new Intl.DateTimeFormat("en-GB",{
    hour: "2-digit",
    minute: "2-digit",
    hour12: false,
})

const dialog = document.getElementById("informatie-dialog");
const editGegevensButton = document.getElementById("editGegevensButton");
const closeDialogButton = document.getElementById("close");
const gegevensForm = document.getElementById("gegevensForm");

editGegevensButton.addEventListener("click", openEditGegevensDialog);
closeDialogButton.addEventListener("click", closeEditGegevensDialog);
gegevensForm.addEventListener("submit", editGegevens);

function openEditGegevensDialog() {
    dialog.show();
    document.getElementById("voornaam-field").value = data.voornaam;
    document.getElementById("achternaam-field").value = data.achternaam;
    document.getElementById("woonplaats-field").value = data.woonplaats;
    document.getElementById("straatnaam-field").value = data.straatnaam;
    document.getElementById("huisNummer-field").value = data.huisNummer;
    document.getElementById("telefoonnummer-field").value = data.telefoonnummer;
}

function closeEditGegevensDialog() {
    dialog.close();
}

function editGegevens(event) {
    event.preventDefault();
    const nieuwData = {
        nieuwVoornaam: gegevensForm.voornaamForm.value,
        nieuwAchternaam: gegevensForm.achternaamForm.value,
        nieuwWoonplaats: gegevensForm.woonplaatsForm.value,
        nieuwStraatnaam: gegevensForm.straatnaamForm.value,
        nieuwHuisNummer: gegevensForm.huisNummerForm.value,
        nieuwTelefoonnummer: gegevensForm.telefoonnummerForm.value,
    }

    const url = `http://localhost:8080/restservices/klanten/${email}`;
    const options = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(nieuwData),
    }

    fetch(url, options).then((response) => response.json())
        .then((data) => {
            console.log(data);
        }).catch((error) => {
            console.log(error);
    })
}

async function getKlant(email) {
    const url = `http://localhost:8080/restservices/klanten/${email}`
    return fetch(url).then((response) => response.json());
}

await laadGegevens(email);

async function laadGegevens(email) {
    try {
        document.getElementById("voornaam").innerHTML = data.voornaam;
        document.getElementById("achternaam").innerHTML = data.achternaam;
        document.getElementById("email").innerHTML = data.emailKlant;
        document.getElementById("woonplaats").innerHTML = data.woonplaats;
        document.getElementById("straatnaam").innerHTML = data.straatnaam;
        document.getElementById("huisNummer").innerHTML = data.huisNummer;
        document.getElementById("telefoonnummer").innerHTML = data.telefoonnummer


        laadAfspraken();
        laadOffertes();

    } catch (error) {
        console.log("An error occured while loading customer data:", error.message);
    }
}

function laadAfspraken() {
    const afspraakTabel = document.getElementById("afspraakTabel");

    for (const afspraak of data.afspraken) {
        const afspraakDatumArray = afspraak.datum;
        const beginTijdArray = afspraak.beginTijd;
        const eindTijdArray = afspraak.eindTijd;
        const woonplaats = afspraak.woonplaats;
        const straatnaam = afspraak.straatnaam;
        const huisNummer = afspraak.huisNummer;
        const onderwerp = afspraak.onderwerp;

        const beginTijd = new Date();
        beginTijd.setHours(beginTijdArray[0]);
        beginTijd.setMinutes(beginTijdArray[1]);
        const eindTijd = new Date();
        eindTijd.setHours(eindTijdArray[0]);
        eindTijd.setMinutes(eindTijdArray[1]);
        const afspraakDatum = new Date(afspraakDatumArray[0], afspraakDatumArray[1] - 1, afspraakDatumArray[2]);
        const formattedBeginTijd = timeFormatter.format(beginTijd);
        const formattedEindTijd = timeFormatter.format(eindTijd);
        const formattedAfspraakDatum = dateFormatter.format(afspraakDatum);

        const afspraakRow = afspraakTabel.insertRow();
        const cell1 = afspraakRow.insertCell(0);
        const cell2 = afspraakRow.insertCell(1);
        const cell3 = afspraakRow.insertCell(2);
        const cell4 = afspraakRow.insertCell(3);
        const cell5 = afspraakRow.insertCell(4);
        const cell6 = afspraakRow.insertCell(5);
        const cell7 = afspraakRow.insertCell(6);

        cell1.setAttribute("class", "tabelBody");
        cell2.setAttribute("class", "tabelBody");
        cell3.setAttribute("class", "tabelBody");
        cell4.setAttribute("class", "tabelBody");
        cell5.setAttribute("class", "tabelBody");
        cell6.setAttribute("class", "tabelBody");
        cell7.setAttribute("class", "tabelBody");

        cell1.innerHTML = formattedAfspraakDatum;
        cell2.innerHTML = formattedBeginTijd;
        cell3.innerHTML = formattedEindTijd;
        cell4.innerHTML = woonplaats;
        cell5.innerHTML = straatnaam;
        cell6.innerHTML = huisNummer;
        cell7.innerHTML = onderwerp;
    }
}

function laadOffertes() {
    const offertes = klant.offertes;
    const offertesTabel = document.getElementById("offertesTabel");
    for (const offerte of offertes) {
        const onderwerp = offerte.onderwerp;
        const bedrag = offerte.bedrag;
        const nummer = offerte.nummer;
        const offerteDatumArray = offerte.datum;
        const geldigheidArray = offerte.geldigheid;
        const omschrijving = offerte.omschrijving;
        const onderdeel = offerte.onderdeel;

        const geldigheid = new Date(geldigheidArray[0] - 1, geldigheidArray[1] - 1, geldigheidArray[2]);
        const formattedGeldigheid = dateFormatter.format(geldigheid);

        const offerteDatum = new Date(offerteDatumArray[0], offerteDatumArray[1] - 1, offerteDatumArray[2]);
        const formattedOfferteDatum = dateFormatter.format(offerteDatum);

        const offerteRow = offertesTabel.insertRow();
        const cell1 = offerteRow.insertCell(0);
        const cell2 = offerteRow.insertCell(1);
        const cell3 = offerteRow.insertCell(2);
        const cell4 = offerteRow.insertCell(3);
        const cell5 = offerteRow.insertCell(4);
        const cell6 = offerteRow.insertCell(5);
        const cell7 = offerteRow.insertCell(6);

        cell1.setAttribute("class", "tabelBody");
        cell2.setAttribute("class", "tabelBody");
        cell3.setAttribute("class", "tabelBody");
        cell4.setAttribute("class", "tabelBody");
        cell5.setAttribute("class", "tabelBody");
        cell6.setAttribute("class", "tabelBody");
        cell7.setAttribute("class", "tabelBody");

        cell1.innerHTML = onderwerp;
        cell2.innerHTML = bedrag;
        cell3.innerHTML = nummer;
        cell4.innerHTML = formattedOfferteDatum;
        cell5.innerHTML = formattedGeldigheid;
        cell6.innerHTML = omschrijving;
        cell7.innerHTML = onderdeel;
    }
}