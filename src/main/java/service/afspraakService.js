import {baseURL} from "../../backendServerConfig";

class AfspraakService {
    getAfspraaken(klant) {
        const url = `${baseURL}/v1/afspraak/${klant}`;
        return fetch(url).then((response) => response.json());
    }

    addAfspraak(afspraak) {
        const url = `${baseURL}/v1/afspraak`;
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(afspraak),
        }

        return fetch(url, options).then((response) => {
            if (!response.ok) {
                throw new Error(response.status);
            }
            return response.json();
        });
    }
}
