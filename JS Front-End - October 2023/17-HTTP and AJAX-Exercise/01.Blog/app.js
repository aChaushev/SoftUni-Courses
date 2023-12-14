function attachEvents() {

    const postsUrl = 'http://localhost:3030/jsonstore/blog/posts';
    const commentsUrl = 'http://localhost:3030/jsonstore/blog/comments';

    const loadPostsBtn = document.getElementById('btnLoadPosts');
    loadPostsBtn.addEventListener('click', loadPosts);

    const viewPostBtn = document.getElementById('btnViewPost');
    viewPostBtn.addEventListener('click', viewPost);

    const selectPosts = document.getElementById('posts');
    const postTitle = document.getElementById('post-title');
    const postBody = document.getElementById('post-body');

    let postsInfo = {};
    const ulComments = document.getElementById('post-comments');

    async function loadPosts() {

        const response = await fetch(postsUrl);
        const data = await response.json();

        Object.values(data).forEach(element => {

            const option = document.createElement('option');
            option.value = element.id;
            option.textContent = element.title;

            selectPosts.appendChild(option);

            postsInfo[element.id] = element;

        });
    }

    async function viewPost() {
        ulComments.textContent = '';

        const response = await fetch(commentsUrl);
        const data = await response.json();

        let postIds = {};

        postTitle.textContent = postsInfo[selectPosts.value].title;
        postBody.textContent = postsInfo[selectPosts.value].body;

        Object.values(data).forEach(element => {
            postIds[element.postId] = [element.id, element.text];

            if (element.postId === selectPosts.value) {
                const li = document.createElement('li');
                li.textContent = element.text;

                ulComments.appendChild(li);
            }

        })
    }

}

attachEvents();