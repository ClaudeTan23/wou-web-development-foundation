const postComment = async (postId, event) =>
{
    const input = document.querySelectorAll(`input[data-post-id="${postId}"]`)[0];
    
    if(input.value !== "")
    {
        const form = new FormData();
        form.append("content", input.value);
        form.append("post_id", postId);


        const promise = await fetch("/comment",
        {
            method: "POST",
            body: form
        });

        if(promise.ok)
        {
            const responseTxt = await promise.text();
            responseContainer(postId, responseTxt);
        }
    }

}

const responseContainer = (postId, jsonString) =>
{
    const string = jsonString.split("###");
    string.pop();

    const sortJson = string.map((value, index, array) => 
    {
        const json = `{${value}}`;

        return JSON.parse(json);
    });

    const commentContainer = document.getElementById(`comment-container-${postId}`);

    commentContainer.innerHTML = "";

    let innerText = "";

    sortJson.forEach(value => 
    {
        innerText +=    `<div class="commented-section mt-2">
                            <div class="d-flex flex-row align-items-center commented-user">
                                <img class="img-fluid img-responsive rounded-circle mr-2" src="/images/${value.image}" width="38">
                                <h5 class="mr-2">${value.username}</h5><span class="dot mb-1"></span><span class="mb-1 ml-2">${value.time}</span>
                            </div>
                            <div class="comment-text-sm"><span>${value.content}</span></div>
                            <hr>
                        </div>`;
    });

    commentContainer.innerHTML = innerText;
    
};   

const loadComments = (postId) =>
{
    fetch(`/comments/${postId}`)
    .then(response => response.text())
    .then(result =>
    {
        responseContainer(postId, result);

    }).catch(e => console.log(e));
}

