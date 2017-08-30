import React, {Component} from 'react';
import ReactDOM from 'react-dom';

import SearchBar from './components/search-bar'
import SearchResults from './components/search-results'

class App extends Component {

    render() {
        return (
            <div>
                <SearchBar/>
                <SearchResults results={[{id: 1, value: 'a'}, {id: 2, value: 'b'}]}/>
            </div>
        );
    }

}

ReactDOM.render(<App/>, document.querySelector("#root"));