document.addEventListener("DOMContentLoaded", function () {
    // First, set data attributes based on hidden spans if needed
    document.querySelectorAll(".physio-card").forEach(card => {
        const button = card.querySelector(".appointment-btn");
        const idSpan = card.querySelector("[data-physio-id-value]") ||
            card.querySelector(".physiotherapist-id-value");

        if (button && idSpan) {
            const physiotherapistId = idSpan.textContent.trim();
            button.setAttribute("data-physio-id", physiotherapistId);
        }
    });

    // Then add click event listeners
    document.querySelectorAll(".appointment-btn").forEach(button => {
        button.addEventListener("click", function () {
            // Get physiotherapist ID from the data attribute
            const physiotherapistId = button.getAttribute("data-physio-id");
            console.log("Physiotherapist ID:", physiotherapistId);

            if (!physiotherapistId || physiotherapistId === "null") {
                alert("Error: Physiotherapist ID is missing.");
                return;
            }

            console.log("Attempting to fetch appointments...");

            fetch(`/appointments/${physiotherapistId}`)
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

                    let message = "Appointments:\n";
                    appointments.forEach(app => {
                        message += `ID: ${app.appointmentid}, Date: ${app.bookingdate}, Time: ${app.bookingtime}, Status: ${app.appointmentstatus}, Type: ${app.appointmenttype}\n`;
                    });

                    alert(message);
                })
                .catch(error => {
                    console.error("Fetch error details:", error);
                    alert("Error fetching data. Please try again.");
                });
        });
    });
});