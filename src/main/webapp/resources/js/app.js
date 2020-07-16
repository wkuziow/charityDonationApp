document.addEventListener("DOMContentLoaded", function () {
    function summary() {
    var categories = [];
    var categoryId = [];
    document.querySelectorAll("div[data-step=\"1\"] div.form-group--checkbox label input").forEach(function (item) {
        if (item.checked) {
            var text = item.parentElement.querySelector("span.description").innerText;
            var id = item.parentElement.querySelector("input").value;
            categories.push(text);
            categoryId.push(id);
            // document.getElementById("summaryCategory").innerText = document.getElementById("summaryCategory").innerText + text + " ";
        }
    });

    categories.forEach(function (element) {
        console.log("Element: " + element);
    });

    categoryId.forEach(function (element) {
        console.log("Element: " + element);
    });

    var numberOfBags = document.querySelector("#numberOfBags").value;
    console.log(numberOfBags);

    var institutionId;
    var institutionName;

    document.querySelectorAll("div[data-step=\"3\"] div.form-group--checkbox label input").forEach(function (item) {
        if (item.checked) {
            institutionId = item.parentElement.querySelector("input").value;
            institutionName = document.querySelector("#institutionName").innerText;
        }
    });
    console.log(institutionId);

    var adress = document.querySelector("#adress").value;
    var city = document.querySelector("#city").value;
    var zipCode = document.querySelector("#postcode").value;
    var phone = document.querySelector("#phone").value;
    var date = document.querySelector("#date").value;
    var time = document.querySelector("#time").value;
    var comment = document.querySelector("#comment").value;
    console.log(adress + city + zipCode + phone + date + date + time + comment);


        var numberOfBagsSummary = document.getElementById("numberOfBagsSummary");
        numberOfBagsSummary.innerText = numberOfBags + " worki. Oddajesz: " + categories;

        var numberOfBagsSummaryHidden = document.getElementById("numberOfBagsSummaryHidden");
        numberOfBagsSummaryHidden.value = numberOfBags;

        var categorriesSummaryHidden = document.getElementById("categorriesSummaryHidden");
        categorriesSummaryHidden.value = categoryId;

        var institutionSummary = document.getElementById("institutionSummary");
        institutionSummary.innerText = "Dla fundacji " + institutionName;

        var institutionSummaryHidden = document.getElementById("institutionSummaryHidden");
        institutionSummaryHidden.value = institutionId;

        var adressSummary = document.getElementById("adressSummary");
        adressSummary.innerText = adress;

        var adressSummaryHidden = document.getElementById("adressSummaryHidden");
        adressSummaryHidden.value = adress;

        var citySummary = document.getElementById("citySummary");
        citySummary.innerText = city;

        var citySummaryHidden = document.getElementById("citySummaryHidden");
        citySummaryHidden.value = city;

        var postCodeSummary = document.getElementById("postCodeSummary");
        postCodeSummary.innerText = zipCode;

        var postCodeSummaryHidden = document.getElementById("postCodeSummaryHidden");
        postCodeSummaryHidden.value = zipCode;

        var phoneSummary = document.getElementById("phoneSummary");
        phoneSummary.innerText = phone;

        var phoneSummaryHidden = document.getElementById("phoneSummaryHidden");
        phoneSummaryHidden.value = phone;

        var pickUpDateSummary = document.getElementById("pickUpDateSummary");
        pickUpDateSummary.innerText = date;

        var pickUpDateSummaryHidden = document.getElementById("pickUpDateSummaryHidden");
        pickUpDateSummaryHidden.value = date;

        var pickUpTimeSummary = document.getElementById("pickUpTimeSummary");
        pickUpTimeSummary.innerText = time;

        var pickUpTimeSummaryHidden = document.getElementById("pickUpTimeSummaryHidden");
        pickUpTimeSummaryHidden.value = time;

        var pickUpCommentsSummary = document.getElementById("pickUpCommentsSummary");
        pickUpCommentsSummary.innerText = comment;

        var pickUpCommentsSummaryHidden = document.getElementById("pickUpCommentsSummaryHidden");
        pickUpCommentsSummaryHidden.value = comment;
    }

    document.getElementById("summaryButton").addEventListener("click", summary);



    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // TODO: get data from inputs and show them in summary
        }

    }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
});
