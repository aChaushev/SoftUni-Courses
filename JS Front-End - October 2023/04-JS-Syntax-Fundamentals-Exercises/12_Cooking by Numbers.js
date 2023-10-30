"use strict";

function solve(number, ...commands) {
    let input= Number(number);
    
    for (let i = 0; i < commands.length; i++) {
        const command = commands[i];
        
        switch(command) {
            case 'chop':
                input /= 2;
                break;
            case 'dice':
                input = Math.sqrt(input);
                break;
            case 'spice':
                input += 1;
                break;
            case 'bake':
                input *= 3;
                break;
            case 'fillet':
                input -= input * 0.2;
                break;
        }
        console.log(input);
    }
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');