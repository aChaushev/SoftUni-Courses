function solve(input) {
  let heroes = [];
  input.forEach((line) => {
    const [heroName, heroLevel, ...items] = line.split(" / ");
    heroes.push({
      Hero: heroName,
      level: heroLevel,
      Items: [...items].join(", "),
    });
  });

  const sortedHeroes = heroes.sort((a, b) => a.level - b.level);

  sortedHeroes.forEach((element) => {
    console.log(
      `Hero: ${element.Hero}\nlevel => ${element.level}\nitems => ${element.Items}`
    );
  });
}

solve([
  "Isacc / 25 / Apple, GravityGun",
  "Derek / 12 / BarrelVest, DestructionSword",
  "Hes / 1 / Desolator, Sentinel, Antara",
]);
solve([
  "Batman / 2 / Banana, Gun",
  "Superman / 18 / Sword",
  "Poppy / 28 / Sentinel, Antara",
]);
