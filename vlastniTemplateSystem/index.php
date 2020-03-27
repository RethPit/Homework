<?php
require_once "Template.php";
$data = [
    "title" => "Toto je titul",
    "caption" => "Toto je nadpis",
    "message" => "Toto je zpráva"
];

$page = new Template("page.html");
$page->setData($data);
echo $page->render();


