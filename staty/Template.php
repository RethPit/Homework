<?php

class Template{
    private $file, $data;

    function __construct($file){
        $this->file = $file;
    }

    public function setData($data){
        $this->data = $data;
    }


    public function render(){
        $htmldata = file_get_contents("page.html");
        foreach($this->data as $key => $value){
           $htmldata = str_replace("{" . $key . "}", $value, $htmldata);  
        }
        return $htmldata;
    }



}