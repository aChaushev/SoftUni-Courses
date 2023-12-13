function loadCommits() {
    const commits = document.getElementById('commits');
    commits.textContent = '';

    const domein = `https://api.github.com/repos/`;
    const username = document.getElementById('username').value;
    const repo = document.getElementById('repo').value;

    const url = `${domein}${username}/${repo}/commits`;
    

    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            if (Array.isArray(data)) {
                data.forEach(commit => {
                    const li = document.createElement('li');
                    li.textContent = `${commit.commit.author.name}: ${commit.commit.message}`;
                    commits.appendChild(li);
                });
            } else {
                const li = document.createElement('li');
                li.textContent = `Error: ${data.message}`;
                commits.appendChild(li);
            }
        })
        .catch(error => {
            const li = document.createElement('li');
            console.log(error);
            li.textContent = `Error: ${error.status} (Not Found)`;
            commits.appendChild(li);
        })

}