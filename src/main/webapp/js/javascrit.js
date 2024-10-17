//Secion1
var section1 = document.querySelector('.Simuler');
var section2 = document.querySelector('.cordonee');
var section3 = document.querySelector('.personnel');
var rightcontainer = document.querySelector('.rightcontainer');
var inputmonths = document.querySelector('.duree').querySelector('input[type="range"]') ,
    output = document.querySelector('.duree').querySelector('input[type="text"]')
;
var pricerange = document.getElementById('montant_range');
var mentualiterange = document.getElementById('mensualite_range');


//Section2
var inputemail = document.getElementById('email').value;
var inputphone = document.getElementById('telephon').value;






var max;
var array = generatearray(120);
inputmonths.setAttribute("max" , array.length - 1);

inputmonths.oninput = function() {

    output.value = array[this.value];

    const priceinit = pricerange.closest('div').querySelector('input[type="text"]').value;
    const months = output.value;


    var annualInterestRate = 0.05;
    const monthlyInterestRate = annualInterestRate / 12;



    var price = (priceinit * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate , -months));


    document.querySelector('#mensualite').value = parseFloat(price).toFixed(2);
    mentualiterange.setAttribute('max' , price.toFixed(2));

}


inputmonths.oninput();



function generatearray (max) {
    const current = [];
    let start = 6;


    while(start <= max) {
        current.push(start);
        start = start+6;
    }
    max = max;

    return current;
}




pricerange.addEventListener('input' , (e) => {
    var closetstextarea = pricerange.closest("div").querySelector('input[type="text"]');
    closetstextarea.value = parseFloat(e.target.value);

    const months = parseFloat(document.querySelector('#dure').value);


    var annualInterestRate = 0.05;
    const monthlyInterestRate = annualInterestRate / 12;

    var price = (e.target.value * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate , -months));



    document.querySelector('#mensualite').value = parseFloat(price).toFixed(2);
    mentualiterange.setAttribute('max' , price.toFixed(2));

})





mentualiterange.addEventListener('input' , (e) => {
    var closetstextarea = mentualiterange.closest('div').querySelector('input[type="text"]');
    var mensualite = closetstextarea.value = e.target.value;





})



// //first page Continue button
function AddSection1Data() {
    var selectprject = document.getElementById('monproject').value;
    var jesuis = document.querySelector('#jesuis_select').value;
    var montant = document.querySelector('#montant_endh_text_aread').value;
    var dure = document.querySelector('#dure').value;
    var mensualite = document.querySelector('#mensualite').value;


    if(selectprject && jesuis && montant && dure && mensualite){

        document.querySelector('#pret').innerText = selectprject;
        var divDetails = document.querySelector('.Détails');
        if (divDetails) {

            divDetails.innerHTML = `
                <h2>Détails de mon crédit</h2>
                <p>Vous êtes: <span>${jesuis}</span></p>
                <p>Montant: <span>${montant} DH</span></p>
                <p>Durée: <span>${dure} mois</span></p>
                <p>Mensualité: <span>${mensualite} DH</span></p>
            `;
        } else {
            divDetails = document.createElement('div');
            divDetails.classList.add('Détails');
            divDetails.innerHTML = `
                <h2>Détails de mon crédit</h2>
                <p>Vous êtes: <span>${jesuis}</span></p>
                <p>Montant: <span>${montant} DH</span></p>
                <p>Durée: <span>${dure} mois</span></p>
                <p>Mensualité: <span>${mensualite} DH</span></p>
            `;
            document.querySelector('.rightcontainer').appendChild(divDetails);
        }



        return true;
    }else{
        console.log('Please fill all the fields');
        return false;
    }

}

function AddSection2Data() {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phoneRegex = /^\+?[1-9]\d{1,14}(\s|-)?(\(?\d{1,4}\)?|\d+)(\s|-)?(\d+(\s|-)?)*$/;

    if(!emailRegex.test(inputemail.value)){
        alert('Wrong email');
        return false;
    }

    if(!phoneRegex.test(inputphone.value)){
        alert('wrong phone');
        return false;
    }

    var UserDetails = document.querySelector('.UserDetails');

    if(UserDetails){
        UserDetails.innerHTML = `
            <h2>Coordonnées et infos personnelles</h2>
                <p>Email: <span>${inputemail.value}</span></p>
                <p>Téléphone: <span>${inputphone.value} DH</span></p>
            `
    }else{
        UserDetails = document.createElement('div');
        UserDetails.classList.add('UserDetails');
        UserDetails.innerHTML = `
            <h2>Coordonnées et infos personnelles</h2>
                <p>Email: <span>${inputemail.value}</span></p>
                <p>Téléphone: <span>${inputphone.value}</span></p>
            `
    }


    document.querySelector('.pretpersonel').insertAdjacentElement('afterend' , UserDetails);


    return true;
}


///////////

let currentSection = 1;
let maxSectionReached = 1;

function nextSection(sectionNumber) {

    if(sectionNumber == 2){
        if(AddSection1Data()){
            showSection(sectionNumber);
            maxSectionReached = 2;
        }
    }

    if(sectionNumber==3){
        if(AddSection2Data()){
            showSection(sectionNumber);
            maxSectionReached = 3;
        }
    }

    console.log(maxSectionReached);


    changingColors(maxSectionReached);


}


function showSection(sectionNumber) {
    section1.style.display = 'none';
    section2.style.display = 'none';
    section3.style.display = 'none';

    document.querySelectorAll('.NumbersPickers').forEach((e) => {
        e.classList.remove('active');
    })

    changingColors(maxSectionReached);
    console.log("sectionnumber" + sectionNumber);


    if(sectionNumber == 1){

        if(!document.querySelector('.first').classList.add('active')){
            document.querySelector('.first').classList.add('active');
        }
        section1.style.display = "flex";
    }else if(sectionNumber == 2) {
        if(!document.querySelector('.second').classList.add('active')){
            document.querySelector('.second').classList.add('active');
        }
        section2.style.display = "flex";
    }
    else{
        document.querySelector('.last').classList.add('active');
        section3.style.display = "flex";
    }



    currentSection = sectionNumber;
}


function goToSection(e,sectionNumber) {
    if (sectionNumber <= maxSectionReached) {
        showSection(sectionNumber);
    }
}


showSection(currentSection);




function changingColors(maxSectionReached) {
    if(maxSectionReached == 3){
        document.querySelector('.first').style.backgroundColor = 'blue';
        document.querySelector('.second').style.backgroundColor = 'blue';
        document.querySelector('.last').style.backgroundColor = 'blue';
    }
    else if(maxSectionReached ==2){
        document.querySelector('.second').style.backgroundColor = 'pink';
        document.querySelector('.first').style.backgroundColor ='pink';
    }
}