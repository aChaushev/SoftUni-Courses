class Song {
  constructor(typeList, name, time) {
    this.typeList = typeList;
    this.name = name;
    this.time = time;
  }
}

function solve(input) {
  let typeToDisplay = input.pop();
  const [_, ...songs] = input; // ингнорира първия елемент и взима останалите
  // let songsCnt = input.shift();

  const result = songs
    .map((songAsText) => {
      // map ще изпълни функцията и ще създаде масив с върнатите стойности
      const [typeList, name, time] = songAsText.split("_");
      const song = new Song(typeList, name, time);

      return song;
    })
      .filter((song) => {
          if (typeToDisplay === "all") {
              return song;
          } else {
              return song.typeList === typeToDisplay
          }
    })
    .map((song) => song.name)
    .join("\n");

  console.log(result);
}

solve([
  3,
  "favourite_DownTown_3:14",
  "favourite_Kiss_4:16",
  "favourite_Smooth Criminal_4:01",
  "favourite",
]);
solve([
  4,
  "favourite_DownTown_3:14",
  "listenLater_Andalouse_3:24",
  "favourite_In To The Night_3:58",
  "favourite_Live It Up_3:48",
  "listenLater",
]);
solve([2, "like_Replay_3:15", "ban_Photoshop_3:48", "all"]);
