<?php
require_once "Template.php";
$handle = fopen("staty.xml", "r");
$text = "";
while (($line = fgets($handle)) !== false) {
    $text = $text . $line;
}


$xml = new SimpleXMLElement($text);


for($i = 0; $i < 10; $i++){
    $data = [
        "title" => "Státy",
        "caption" => "Státy",
        "message" => "Toto je zpráva",
        "State"   => "Populace",
        "Population" => "Populace",
        "Capital"   => "Hlavní město"  
    ];
}

$i = 0;
foreach ($xml->state as  $value) {
        $data["State" . $i] = $value->name->__toString();
        $data["Population" . $i] = $value->population->__toString();
        $data["Capital" . $i] = $value->capital->__toString();
        $i++;
}


$page = new Template("page.html");
$page->setData($data);
echo $page->render();


