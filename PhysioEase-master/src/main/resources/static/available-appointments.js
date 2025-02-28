document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".physio-card").forEach(card => {
        const button = card.querySelector(".appointment-btn");
        const idSpan = card.querySelector(".physiotherapist-id-value");

        if (button && idSpan) {
            const physiotherapistId = idSpan.textContent.trim();
            console.log("Physiotherapist ID Retrieved:", physiotherapistId);
            button.setAttribute("data-physio-id", physiotherapistId);
        }
    });

    document.querySelectorAll(".appointment-btn").forEach(button => {
        button.addEventListener("click", function () {
            const physiotherapistId = button.getAttribute("data-physio-id");

            console.log("Redirecting to:", `/appointments/view/${physiotherapistId}`);

            if (!physiotherapistId || physiotherapistId === "null") {
                alert("Error: Physiotherapist ID is missing.");
                return;
            }

            // ✅ Redirect to the correct page (NOT fetch it as JSON)
            window.location.href = `/appointments/view/${physiotherapistId}`;
        });
    });
});
