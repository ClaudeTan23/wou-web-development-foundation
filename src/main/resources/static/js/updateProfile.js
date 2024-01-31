const updateBtn  = document.getElementById("changepw");
const ImgProfile = document.getElementById("profileImage");
const originalImage = document.getElementById("profileIcon").src;

let changeStatus = false;
let changeImg    = false;
let blobImg = null;

updateBtn.addEventListener("click", (e) =>
{
    const passwordContainer = document.getElementById("password");
    
    if(!changeStatus)
    {
        passwordContainer.children[0].innerHTML = `<input type="password" name="password" placeholder="New password" class="text-secondary" style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 2px 6px;" required>
                                                   <input type="password" name="cPassword" placeholder="Confirm password" class="text-secondary" style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 2px 6px;" required>`;
        e.target.textContent = "Cancel";
    } else 
    {
        passwordContainer.children[0].innerHTML = `<span>*******</span>
                                                   <input type="password" name="cPassword" placeholder="Confirm password" class="text-secondary" style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 2px 6px;" hidden readonly>`;
        e.target.textContent = "Change";
    }

    changeStatus = changeStatus ? false : true;                        
});


ImgProfile.addEventListener("change", () => 
{
    let file = document.getElementById("profileImage").files[0];
    let profile = document.getElementById("profileIcon");

    if(blobImg !== null) URL.revokeObjectURL(blobImg);

    blobImg = URL.createObjectURL(file);
    profile.src = blobImg;

    document.getElementById("cancel-img").innerHTML = `<button id="imgCancel" class="btn btn-close" onClick="cancelImgBtn()">Cancel</button>`;
    
});

const cancelImgBtn = () =>
{
    document.getElementById("profileIcon").src = originalImage;
    URL.revokeObjectURL(blobImg);
    document.getElementById("cancel-img").innerHTML = ``;
    document.getElementById("profileImage").value = "";

};



