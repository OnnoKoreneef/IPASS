import {ingelogd} from "./shared.js";

console.log(ingelogd);

if (ingelogd) {
    document.getElementById("login").innerHTML = "Mijn account";
    console.log("check4")
} else {
    console.log("check3")
}