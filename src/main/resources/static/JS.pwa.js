if ("serviceWorker" in navigator) {

    window.addEventListener("load", function () {

        navigator.serviceWorker.register("/service-worker.js")

            .then(function () {

                console.log("PWA registrada");

            })

            .catch(function (error) {

                console.log("Error:", error);

            });

    });
}