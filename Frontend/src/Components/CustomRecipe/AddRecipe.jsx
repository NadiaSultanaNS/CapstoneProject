import axios from 'axios';
import React, { useState } from 'react'

export default function AddRecipe() {
    const [recipeTitle, setRecipeTitle] = useState("");
    const [recipeIngred, setRecipeIngred] = useState("");
    const [recipeDetail, setRecipeDetail] = useState("");
    const [errorMsg, setErrorMsg] = useState("");

    function handleSubmit() {
        setErrorMsg("");
        if (recipeTitle.trim() === "") {
            setErrorMsg("Recipe Title Can Not Be Empty")
            return;
        }
        if (recipeIngred.trim() === "") {
            setErrorMsg("Recipe Ingredients Can Not Be Empty")
            return;
        }
        if (recipeDetail.trim() === "") {
            setErrorMsg("Recipe Details Can Not Be Empty")
            return;
        }
        const recipe = {
            recipeTitle: recipeTitle.trim(),
            recipeIngrd: recipeIngred.trim(),
            recipeDesc: recipeDetail.trim()

        }

        axios.post("http://localhost:3000/recipes", recipe)
            .then(res => {
                console.log("Recipe has been added")
                console.log(res.data);
            }).catch(error => {
                console.log(error)
            })
        // axios.get("http://localhost:3000/status").then(res => {
        //     console.log(res)
        // }).catch(err => {
        //     console.log(err);
        // })


        console.log({ recipeTitle, recipeIngred, recipeDetail });
    }






    return (
        <div className="container text-right"><p className='text-danger'>
            {errorMsg}
        </p><form>
                <div className="form-group p-2">
                    <label htmlFor="exampleFormControlInput1">Recipe Title</label>
                    <input type="text" className="form-control" value={recipeTitle} onChange={(e) => { setRecipeTitle(e.target.value) }} />
                </div>
                <div className="form-group p-2">
                    <label htmlFor="exampleFormControlTextarea1">Ingredients List</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" rows="3" value={recipeIngred} onChange={(e) => { setRecipeIngred(e.target.value) }}></textarea>
                </div>
                <div className="form-group p-2">
                    <label htmlFor="exampleFormControlTextarea1">Description</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" rows="3" value={recipeDetail} onChange={(e) => { setRecipeDetail(e.target.value) }}></textarea>
                </div>
                <button type="button" className="btn btn-dark m-2" onClick={handleSubmit}>Add Your Recipe</button>
            </form></div>
    )
}
