DELETE from t_birds;
DELETE from t_colors;
DELETE from t_birds_colors;
DELETE from t_beak_shapes;
DELETE from t_feet_shapes;
DELETE from t_sizes;

INSERT INTO t_colors (rgb_code, name)
VALUES
('FFFFFF', 'blanc'),
('000000', 'noir'),
('A0A0A0', 'gris'),
('663300', 'marron'),
('FF0000', 'rouge'),
('FFFF00', 'jaune'),
('FF9933', 'orange'),
('0066CC', 'bleu'),
('009900', 'vert'),
('6600CC', 'violet'),
('FF99CC', 'rose'),
('F9ECD2', 'beige');



INSERT INTO t_beak_shapes (name)
VALUES
('bec conique de granivore'),
('bec court et pointu d''insectivore'),
('bec long et pointu d''insectivore'),
('bec de pêcheur'),
('bec épuisette'),
('bec de rapace'),
('bec mi-long et incurvé'),
('autre');

INSERT INTO t_feet_shapes (name)
VALUES
('coureur (autruche)'),
('palmipède (oie)'),
('échassier (cigogne)'),
('rapace (aigle)'),
('grimpeur (perroquet)'),
('passereau (rouge-gorge)'),
('syndactyle (martin-pêcheur)'),
('autre');

INSERT INTO t_sizes (name)
VALUES
('XS (moineau, <20cm)'),
('S (merle >20 cm, <40 cm)'),
('M (corneille >40 cm, <70 cm)'),
('L (oie >70 cm, <100 cm)'),
('XL (flamant > 100cm)');


INSERT INTO t_birds (scientific_name, common_name, image, beak_shape_id, feet_shape_id, size_id, xeno_id, description)
VALUES
('Pica pica', 'Pie bavarde', 'eurmag1.jpg', 1, 6, 2, 883303, 'La Pie bavarde est un grand corvidé noir et blanc à longue queue. L''adulte a la tête, la poitrine, le dos et le bas-ventre noirs. Les ailes et la queue présentent un plumage bleu-vert métallique. L''abdomen est d''un blanc pur.'),
('Prunella modularis', 'Accenteur mouchet', 'dunnoc1.jpg', 2, 6, 1, 883313, 'L''Accenteur mouchet Prunella modularis est une espèce commune, comparable au Moineau domestique Passer domesticus. Les deux espèces sont souvent confondues. Buffon l''avait surnommé le « traîne-buisson ». Le mâle adulte a les parties supérieures brunes striées de brun clair et plus foncé sur le manteau et le croupion. Les ailes et la queue sont brun foncé. On distingue une barre alaire fine de couleur chamois.Les parties inférieures sont gris-bleu, excepté les flancs brunâtres striés de brun foncé. Le dessous des ailes est gris-bleu. Sur la tête, le front et la calotte sont bruns et striés de brun plus foncé, rejoignant ainsi la couleur du manteau. La face est gris-bleu avec les joues brunes striées comme la calotte. On peut voir un large sourcil gris-bleu. Le bec fin est noirâtre, avec la base de la mandibule inférieure rougeâtre. Les yeux sont brun-roux. Les pattes et les doigts sont brun-rouge. La femelle est très semblable, mais légèrement plus terne, avec des zones gris pâle sur la tête et les parties inférieures. Le juvénile a le corps brun intensément strié de noirâtre. La tête est plus brune que chez les adultes et ne présente pas du tout de gris. La barre alaire claire est évidente. Les yeux sont plutôt sombre.'), 
('Cercotrichas galactotes', 'Agrobate roux', 'rutscr1.jpg', 2, 6, 1, 861520, 'L''Agrobate roux est une espèce de petits passereaux dont la silhouette et l''attitude rappellent celles du Rossignol philomèle. C''est un oiseau rarement observé en France.'), 
('Clanga clanga', 'Aigle criard', 'grseag1.jpg', 6, 4, 3, 608441, 'Ce rapace au bec crochu et aux griffes puissantes et acérées peut être confondu avec son cousin l''Aigle pomarin. Les points de ressemblances entre ces deux espèces sont si nombreux qu''ils rendent bien souvent leur identification difficile. En effet, tout comme l''Aigle pomarin, il est entièrement brun noir avec des reflets cuivrés.'), 
('Aquila fasciata', 'Aigle de Bonelli', 'boneag2.jpg', 6, 4, 3, 792286, 'L''Aigle de Bonelli mesure de 60 à 70 cm, a une envergure de 150 à 170 cm et pèse entre 1 500 et 2 000 grammes. Au niveau de son plumage, une tache blanche caractéristique qui grandit avec l''âge orne son dos et il présente un fort contraste entre ses ailes sombres et le reste du corps, blanc. Les jeunes ont, quant à eux, une couleur roussâtre et ne revêtent leur plumage adulte que vers 3 à 4 ans.'), 
('Aquila nipalensis', 'Aigle des steppes', 'steeag1.jpg', 6, 4, 4, 879526, 'Il mesure de 62 à 81 cm de longueur et a une envergure de 165 à 200 cm. Les femelles pesant 2,3 à 4,1 kg sont légèrement plus grandes que les mâles qui font de 2 à 3,5 kg. Il a les parties supérieures, les rémiges des ailes et la queue brun noir.'),
('Aquila adalberti', 'Aigle ibérique', 'spaeag1.jpg', 6, 4, 4, 864217, 'Cet oiseau mesure 71 à 89 cm de longueur pour une envergure de 187 à 215 cm et une masse de 3,1 à 4,7 kg. Le plumage adulte marron-rougeâtre définitif est atteint entre l''âge de 6 et 8 ans. '), 
('Aquila heliaca', 'Aigle impérial', 'impeag1.jpg', 6, 4, 4, 731082, 'Il mesure de 68 à 87 cm de longueur pour une envergure de 2 mètres et un poids de 4 kg. Bien que plutôt grand pour un aigle, il est plutôt petit pour le genre Aquila. Il possède un plumage essentiellement noir-brun, avec une nuque jaune crème distinctive et des épaules blanches.'),
('Ciconia ciconia', 'Cigogne blanche', 'whisto1.jpg', 4, 3, 4, 878788, 'Elle mesure entre 90 et 115 cm à l''age adulte pour une envergure de 195 à 215 cm. Le plumage des adultes est blanc à l''exception des rémiges et des grandes couvertures qui sont noires. Ce grand échassier aux bec et pattes rouges vifs peut facilement être confondu avec ses cousins les hérons. On peut néanmoins les différencier à leur façon de voler : les cigognes volent le cou tendu, un peu incliné au dessous de l''horizontale et comme alourdi par le bec en avant contrairement aux hérons qui volent le cou replié en " s ". Par ailleurs moins aquatiques que ces derniers, elles ne chassent guère à l''affût, mais en marchant à découvert.'), 
('Cygnus cygnus', 'Cygne chanteur', 'whoswa.jpg', 5, 2, 5, 882438, 'Le cygne chanteur ou cygne sauvage, est une espèce d''oiseaux appartenant à la famille des Anatidae. C''est un grand cygne de l''hémisphère Nord. '), 
('Phoenicopterus roseus', 'Flamant rose', 'grefla3.jpg', 8, 3, 5, 567950,'Présent sur les côtes méditerranéennes toute l''année, il se nourrit de petits crustacés qui lui donnent sa couleur rose.'), 
('Larus glaucoides kumlieni', 'Goéland arctique (kumlieni)', 'kumgul1.jpg', 7, 2, 3, 644754, 'Le Goéland arctique a une taille proche du Goéland argenté, les adultes ont un plumage blanc au niveau de la tête, du cou et du ventre. Au niveau des ailes et du dos, ils ont un plumage gris clair qui peut également virer au blanc. Ils ont les pattes couleur chair et ont, à l''instar d''autres espèces comme le Goéland brun, le Goéland argenté ou le Goéland marin, un bec jaune avec une tache rouge au niveau de la mandibule inférieure. '),
('Ardea melanocephala', 'Héron mélanocéphale', 'blhher1.jpg', 4, 3, 4, 741404, 'Le héron mélanocéphale est un grand héron (environ 90 centimètres de long pour une envergure dépassant les 150 centimètres1,2) dont l''adulte a un dessus et ses côtés de tête noirs, avec une huppe à l''arrière du crâne.'), 
('Alcedo atthis', 'Martin-pêcheur d''Europe', 'comkin1.jpg', 4, 7, 2, 882513, 'Le Martin-pêcheur (l''Alcyion des anciens grecs) mesure environ 16 cm, pour une envergure de 25 à 28 cm et un poids de 30 à 44 grammes. Le dessus de sa tête, ainsi que son dos et sa queue sont bleu-vert, foncé ou brillant selon les endroits. Ses joues, comme sa poitrine et son ventre, sont roux-orangé vif. Ses pattes sont rouges.'), 
('Apus affinis', 'Martinet des maisons', 'litswi1.jpg', 2, 8, 1, 746533, 'Il fait partie du groupe des petits martinets à croupion blanc. Il se distingue assez facilement des autres par sa queue carrée et non plus ou moins fourchue (mais qui apparaît arrondie lorsqu''elle est entièrement étalée). La tache blanche du croupion est large et bien visible sur le côté. La tache blanche à la gorge est, elle aussi, assez large.'), 
('Aegithalos caudatus', 'Orite à longue queue', 'lottit1.jpg', 2, 6, 1, 882627, 'Cet oiseau mesure 13 à 14,5 cm (dont 8 à 9 pour la queue) pour une envergure de 17 à 18 cm et une masse de 6 à 10 g. C''est un minuscule oiseau avec une très longue queue et des petites ailes rondes, au ventre blanc légèrement rosé, à la tête blanche et grise avec, chez la grande majorité des individus vivant au Benelux, en France et en Suisse, une bande noire du front à la nuque passant au-dessus de l''œil.'), 
('Passer domesticus', 'Moineau domestique', 'houspa.jpg', 1, 6, 1, 882124, 'Le moineau domestique a le corps large et charpenté, une tête assez grosse et un gros bec. Son dos est brunâtre densément strié de noir. Plumage souvent ébouriffé avec une attitude ramassée. Tête et pattes rentrées une fois perché. Il existe un dimorphisme sexuel apparent entre le mâle et la femelle. Le mâle porte une large bavette noire (absente chez la femelle) sur la gorge et la poitrine. Le dessus de la tête est gris cendré, le ventre grisâtre et le dos brun marron chocolat. La femelle se distingue du mâle par son plumage beaucoup plus terne, un sourcil crème derrière l''œil, l''absence de bavette noire et son dos est marron sans teinte chocolat. Pour finir, son cri bien connu est un « chip » ou « piap » : celui-ci permet le contact entre les individus.'),
('Dendrocopos major', 'Pic épeiche', 'grswoo.jpg', 3, 5, 1, 883467, 'Le pic épeiche se reconnaît facilement à son plumage noir et blanc et les sous-caudales rouges (plumes situées sous la queue).'), 
('Picus viridis', 'Pic vert', 'eugwoo2.jpg', 3, 5, 2, 883831, 'Se distingue par sa grande taille et son plumage vert. Calotte rouge sur la tête. dimorphisme sexuel existant mais peu marqué : les mâles ont une tâche rouge au centre de la moustache noire alors que les femelles ont des moustaches entièrement noires. Le juvénile est très moucheté.'), 
('Columba livia', 'Pigeon biset', 'rocpig.jpg', 2, 6, 2, 550328, 'Le pigeon biset urbain, ou pigeon de ville, est la forme domestique du Pigeon biset Columba livia. Leurs populations sont issues principalement sinon exclusivement d''animaux d''élevage ayant échappé au contrôle de l''homme (phénomène de marronnage). Ceci est mis en évidence par leurs phénotypes variés qui reflètent fréquemment des caractères sélectionnés chez certaines races domestiques (coloris blanc, roux, pigeon cravaté…). Certains sujets montrent cependant un phénotype tout à fait sauvage.'), 
('Columba palumbus', 'Pigeon ramier', 'cowpig1.jpg', 2, 6, 3, 883871, 'Le pigeon ramier a des tâches blanches sur les côtés du cou et la poitrine plutôt rosée. Les marques blanches sur les ailes sont très visibles en vol. C''est un oiseau essentiellement granivore qui prélève sa nourriture au sol. Il confectionne un nid peu élaboré fait de brindilles posées sur sur une branche ou une enfourchure.'),
('Alca torda', 'Pingouin torda', 'razorb.jpg', 7, 2, 2, 837421, 'Les adultes sont noirs sur le dos et blancs sur le ventre, la poitrine est brun-noir. Le bec est de couleur noire, et porte une à plusieurs rayures transversales grises et une rayure transversale blanche ; la commissure des lèvres est jaune. Une autre rayure blanche part de la base du bec et s''allonge longitudinalement jusqu''à l''œil, qui est de couleur noire. Une rayure blanche traverse aussi le bout des ailes.'),
('Luscinia megarhynchos', 'Rossignol philomèle', 'comnig1.jpg', 2, 6, 1, 880731 , 'A peine plus gros que le Rouge-gorge avec ses 16 cm queue comprise et ses 23 grammes, le rossignol philomèle est un passereau d''aspect plutôt terne avec un dos brun-roux, un ventre gris et des rectrices rousses. Il est doté de longues pattes rosées et d''un long bec brun foncé. Il n''y a pas de dimorphisme sexuel. Les jeunes ont un plumage tacheté rappelant les couleurs de l''adulte notamment sur les rectrices. Ils pourraient être confondus avec de jeunes Rougequeue, mais s''en distinguent par leur comportement discret à ras de terre. Cet oiseau a une longévité de six ans.'),
('Geronticus eremita', 'Ibis chauve', 'waldra1.jpg', 8, 3, 4, 361539, 'C''est un échassier noir avec des reflets bleutés, verts ou pourprés8. Il a la tête et une partie du cou glabres, avec une peau couleur rouge cerise, et gris ardoise sur l''occiput. Il porte une collerette de longues plumes étroites autour de la partie non-glabre de son cou. Son long bec recourbé vers le bas et ses pattes sont rouge vif. '),
('Parus major', 'Mésange charbonnière', 'gretit1.jpg', 2, 6, 1, 883597, 'C''est la plus grande des mésanges et elle est facilement identifiable grâce à sa calotte, sa gorge et sa cravate noire, cette dernière étant plus épaisse chez le mâle que chez la femelle. Ses joues sont blanches et le reste de son plumage est de couleur jaune ou jaune vert à l''exception des ailes et de la queue qui sont plutôt noires. C''est une espèce sédentaire et largement répandue.');


INSERT INTO t_birds_colors (bird_id, color_id)
VALUES
-- 'Pica pica', 'Pie bavarde'
(1, 1), 
(1, 2),
(1, 8),
-- 'Prunella modularis', 'Accenteur mouchet'
(2, 4),
(2, 3),
-- 'Cercotrichas galactotes', 'Agrobate roux'
(3, 4), 
(3, 3),
(3, 7),
-- 'Clanga clanga', 'Aigle criard'
(4, 4), 
(4, 6),
(4, 12),
(4, 2),
-- 'Aquila fasciata', 'Aigle de Bonelli'
(5, 4), 
(5, 12),
(5, 3),
(5, 6),
-- 'Aquila nipalensis', 'Aigle des steppes'
(6, 4), 
(6, 6),
(6, 12),
(6, 2),
-- 'Aquila adalberti', 'Aigle ibérique'
(7, 4), 
(7, 3),
(7, 2),
(7, 1),
-- 'Aquila heliaca', 'Aigle impérial'
(8, 4), 
(8, 12),
(8, 7),
(8, 6),
(8, 2),
-- 'Ciconia ciconia', 'Cigogne blanche'
(9, 2), 
(9, 1),
(9, 5),
(9, 7),
(9, 3),
-- 'Cygnus cygnus', 'Cygne chanteur' 
(10, 1), 
(10, 2),
(10, 6),
(10, 7),
-- 'Phoenicopterus roseus', 'Flamant rose'
(11, 11), 
(11, 2),
-- 'Larus glaucoides kumlieni', 'Goéland arctique (kumlieni)' 
(12, 1), 
(12, 3),
(12, 6),
(13, 2),
-- 'Ardea melanocephala', 'Héron mélanocéphale' 
(13, 3), 
(13, 1),
-- 'Alcedo atthis', 'Martin-pêcheur d''Europe' '
(14, 1), 
(14, 8),
(14, 7),
(14, 2),
-- 'Apus affinis', 'Martinet des maisons 
(15, 1), 
(15, 2),
-- 'Aegithalos caudatus', 'Orite à longue queue'
(16, 1), 
(16, 2),
(16, 4),
(16, 5),
-- 'Passer domesticus', 'Moineau domestique'
(17, 5),
(17, 4),
(17, 3),
(17, 2),
-- 'Dendrocopos major', 'Pic épeiche'
(18, 2),
(18, 1),
(18, 5),
-- 'Picus viridis', 'Pic vert'
(19, 9),
(19, 5),
(19, 2),
-- 'Columba livia', 'Pigeon biset'
(20, 3),
(20, 2),
(20, 9),
(20, 10),
-- 'Columba palumbus', 'Pigeon ramier'
(21, 10),
(21, 9),
(21, 3),
(21, 1),
-- 'Alca torda', 'Pingouin torda'
(22, 2),
(22, 1),
-- 'Luscinia megarhynchos', 'Rossignol philomèle'
(23, 4),
(23, 12),
(23, 7),
-- 'Geronticus eremita', 'Ibis chauve'
(24, 2),
(24, 5),
(24, 10),
(24, 9),
-- 'Parus major', 'Mésange charbonnière'
(25, 2),
(25, 6),
(25, 1),
(25, 3);
