document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".appointment-btn").forEach(button => {
        button.addEventListener("click", function () {
            const jsonMessage = {
                message: "Here are the available appointments",
                status: "success"
            };

            alert(JSON.stringify(jsonMessage, null, 2)); // Show JSON in an alert box
            console.log(jsonMessage); // Log JSON to the console
        });
    });
});
