import React from 'react';
import {connect} from 'react-redux'
import {bindActionCreators} from 'redux';
import {selectResult} from '../actions/index'

const SelectedResultDetails = (props) => {
    console.log('props = ', props);
    const result = props.result;

    if (!result) {
        return (
            <div>{'<selected-result-detail>'}</div>
        );
    }

    return (
        <div onClick={result => this.props.selectResult(result)}>
            <h2>Details for {result.id}</h2>
            <div>value = {result.value}</div>
        </div>
    );
};

function mapStateToProps(state) {
    return {
        result: state.selectedResult
    };
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(
        {
            selectResult: selectResult
        },
        dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(SelectedResultDetails)