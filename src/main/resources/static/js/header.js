function onSubmitSearch(event) {
    event.preventDefault();
    const query = event.target.children[0].value;
    window.location.assign("/search?q="+query)
}

document.addEventListener("DOMContentLoaded", function () {
    const forms = document.getElementsByClassName('search-form');
    for (let form of forms) {
        form.addEventListener('submit', onSubmitSearch)
    }
});