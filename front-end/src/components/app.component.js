import React, {Component} from "react";

import SearchBar from './search-bar';
import SearchResults from '../containers/search-results.container';
import ResultDetails from '../containers/result-details.container';

class App extends Component {

    render() {
        return (
            <div>
                <SearchBar/>
                <SearchResults/>
                <ResultDetails />
            </div>
        );
    }

}

export default App;