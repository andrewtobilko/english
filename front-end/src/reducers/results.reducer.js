export default function (currentState = null, action) {
    console.log('results.reducer.js', currentState, action);

    return [
        {id: 1, value: 'a'},
        {id: 2, value: 'b'}
    ]
}