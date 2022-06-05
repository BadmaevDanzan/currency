let url = 'http://' + location.host + '/api';
let urlRates = 'https://openexchangerates.org/api/currencies.json';
let rates = getRates();

document.addEventListener("DOMContentLoaded", function (event) {
    getCurrency(null);

    let selectDoc = document.getElementById("select");
    selectDoc.addEventListener('change', (event) => {
        getCurrency(selectDoc.value);
    });


});

function getCurrency(currency) {
    let getData = getRequest(currency);
    let imgUrl = getData.imgUrl;
    let rate = getData.currency;
    let yesterdayRate = getData.yesterdayRate;
    let todayRate = getData.todayRate;
    let profit = getData.profit;

    var iFrame = document.getElementById("frameImg");
    iFrame.setAttribute("src", imgUrl);

    var currency = document.getElementById("currency");
    currency.innerText = 'Валюта: ' + getRate(rate) + ' (' + rate + ')';

    var yesterday = document.getElementById("yesterdayValue");
    yesterday.innerText = yesterdayRate;

    var today = document.getElementById("todayValue");
    today.innerText = todayRate;

    var profitDoc = document.getElementById("arrow");
    if (profit === 'rich') {
        profitDoc.style.transform = "rotate(180deg)";
    } else {
        profitDoc.style.transform = null;
    }

    let selectDoc2 = document.getElementById("select");
    for (const [key, value] of Object.entries(rates)) {
        var option = document.createElement("option");
        option.text = value + ' (' + key + ')';
        option.value = key;
        selectDoc2.appendChild(option)
    }
}


function getRequest(currency) {
    var param = '';
    if (currency != null) {
        param = '?currency=' + currency;
    }
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url + param, false);
    xmlHttp.send();
    return JSON.parse(xmlHttp.responseText);
}

function getRates() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", urlRates, false);
    xmlHttp.send();
    return JSON.parse(xmlHttp.responseText);
}

function getRate(rate) {
    return rates[rate];
}