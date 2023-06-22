import Afspraak from '/model/Afspraak.java';
import "/service/afspraakService";

function submit(event) {
    event.preventDefault();

    const afspraak = new Afspraak;
    afspraakService.addAfspraak(afspraak)
        .then((result) => {
            window.location.href="/";
        })
        .catch((error) => {
            showError(error);
        })
}