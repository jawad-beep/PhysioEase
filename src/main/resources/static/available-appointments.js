document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".appointment-btn").forEach(button => {
        button.addEventListener("click", function () {
            console.log("Button clicked!");

            // Log the fetch attempt
            console.log("Attempting to fetch appointments...");

            fetch('/api/appointments/all')
                .then(response => {
                    console.log("Response received:", response);
                    if (!response.ok) {
                        throw new Error(`HTTP error! Status: ${response.status}`);
                    }
                    return response.json();
                })
                .then(appointments => {
                    console.log("Appointments data:", appointments);

                    if (appointments.length === 0) {
                        alert("No appointments available.");
                        return;
                    }

                    // Format appointments into a readable string
                    let message = "Appointments:\n";
                    appointments.forEach(app => {
                        message += `ID: ${app.appointmentid}, Patient: ${app.patientid}, Physiotherapist: ${app.physiotherapistid}, Date: ${app.bookingdate}, Time: ${app.bookingtime}, Status: ${app.appointmentstatus}, Type: ${app.appointmenttype}\n`;
                    });

                    // Show appointments in alert
                    alert(message);
                })
                .catch(error => {
                    console.error("Fetch error details:", error);
                    alert("Error fetching data. Please try again.");
                });
        });
    });
});