document.addEventListener('DOMContentLoaded', function () {
    const searchButton = document.getElementById("searchButton");

    searchButton.addEventListener("click", function () {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(sendPosition, failedToGet);
        } else {
            alert("Geolocation is not supported by this browser.");
        }
    });
});

function sendPosition(position) {
    const radiusDropdown = document.getElementById("radius");
    const specialtyDropdown = document.getElementById("specialty");
    const selectedRadius = radiusDropdown.value;
    const selectedSpecialty = specialtyDropdown.value;

    const locationData = {
        latitude: position.coords.latitude,
        longitude: position.coords.longitude,
        patientRadius: parseInt(selectedRadius),
        patientSpecialization: selectedSpecialty
    };

    console.log('Sending data:', locationData); // Debug log

    fetch('/api/getPatientLocation', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(locationData)
    })
        .then(response => response.text())
        .then(() => {
            window.location.href = "/view/getPhysiotherapists";
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error sending location data');
        });
}

function failedToGet() {
    alert("Failed to get location. Please enable location services and try again.");
}