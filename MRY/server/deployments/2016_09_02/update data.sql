-- 药物中文首字母配置
UPDATE medicine SET chemical_name_abbr='ynpl',name_abbr='ys' WHERE id=1;
UPDATE medicine SET chemical_name_abbr='ynpl',name_abbr='ynd' WHERE id=2;
UPDATE medicine SET chemical_name_abbr='bnpl',name_abbr='ltx' WHERE id=3;
UPDATE medicine SET chemical_name_abbr='fxpl',name_abbr='mn' WHERE id=4;
UPDATE medicine SET chemical_name_abbr='lnpl',name_abbr='jcr' WHERE id=5;
UPDATE medicine SET chemical_name_abbr='ktpl',name_abbr='kbt' WHERE id=6;
UPDATE medicine SET chemical_name_abbr='lmpl',name_abbr='rt' WHERE id=7;
UPDATE medicine SET chemical_name_abbr='pdpl',name_abbr='ysd' WHERE id=8;
UPDATE medicine SET chemical_name_abbr='lst',name_abbr='ksy' WHERE id=9;
UPDATE medicine SET chemical_name_abbr='ebst',name_abbr='abw' WHERE id=10;
UPDATE medicine SET chemical_name_abbr='ebst',name_abbr='ytqjn' WHERE id=11;
UPDATE medicine SET chemical_name_abbr='xst',name_abbr='dwjn' WHERE id=12;
UPDATE medicine SET chemical_name_abbr='xst',name_abbr='syjn' WHERE id=13;
UPDATE medicine SET chemical_name_abbr='tmst',name_abbr='mksp' WHERE id=14;
UPDATE medicine SET chemical_name_abbr='kdst',name_abbr='bls' WHERE id=15;
UPDATE medicine SET chemical_name_abbr='cdst',name_abbr='wey' WHERE id=16;
UPDATE medicine SET chemical_name_abbr='mtle',name_abbr='btlk' WHERE id=17;
UPDATE medicine SET chemical_name_abbr='mtlehsp',name_abbr='btlkhsp' WHERE id=18;
UPDATE medicine SET chemical_name_abbr='lstqlsq',name_abbr='hjy' WHERE id=19;
UPDATE medicine SET chemical_name_abbr='ebstqlsq',name_abbr='abl' WHERE id=20;
UPDATE medicine SET chemical_name_abbr='pdplydpap',name_abbr='bpl' WHERE id=21;
UPDATE medicine SET chemical_name_abbr='glqthsp',name_abbr='dmk' WHERE id=22;
UPDATE medicine SET chemical_name_abbr='glqtp',name_abbr='dmk' WHERE id=23;
UPDATE medicine SET chemical_name_abbr='glzsksp',name_abbr='ryn' WHERE id=24;
UPDATE medicine SET chemical_name_abbr='glzsp',name_abbr='mzd' WHERE id=25;
UPDATE medicine SET chemical_name_abbr='glktp',name_abbr='tsp' WHERE id=26;
UPDATE medicine SET chemical_name_abbr='glmlp',name_abbr='yml' WHERE id=27;
UPDATE medicine SET chemical_name_abbr='glmlp',name_abbr='yr' WHERE id=28;
UPDATE medicine SET chemical_name_abbr='ejsgp',name_abbr='ghz' WHERE id=29;
UPDATE medicine SET chemical_name_abbr='ejsgp',name_abbr='mdk' WHERE id=30;
UPDATE medicine SET chemical_name_abbr='ejsghsp',name_abbr='bk' WHERE id=31;
UPDATE medicine SET chemical_name_abbr='akbtp',name_abbr='btp' WHERE id=32;
UPDATE medicine SET chemical_name_abbr='akbtp',name_abbr='kbp' WHERE id=33;
UPDATE medicine SET chemical_name_abbr='fglbtp',name_abbr='bx' WHERE id=34;
UPDATE medicine SET chemical_name_abbr='rgln',name_abbr='nhl' WHERE id=35;
UPDATE medicine SET chemical_name_abbr='rgln',name_abbr='fld' WHERE id=36;
UPDATE medicine SET chemical_name_abbr='ngln',name_abbr='tl' WHERE id=37;
UPDATE medicine SET chemical_name_abbr='nglyblgsl',name_abbr='czrydszsy' WHERE id=38;
UPDATE medicine SET chemical_name_abbr='mdyds',name_abbr='mdyds' WHERE id=39;
UPDATE medicine SET chemical_name_abbr='lpydszsy',name_abbr='lpydszsy' WHERE id=40;
UPDATE medicine SET chemical_name_abbr='mdydszsy',name_abbr='mdydszsy' WHERE id=41;
UPDATE medicine SET chemical_name_abbr='lpydszsy',name_abbr='lpydszsy' WHERE id=42;
UPDATE medicine SET chemical_name_abbr='gjydszsy',name_abbr='gjydszsy' WHERE id=43;
UPDATE medicine SET chemical_name_abbr='bhsaldp',name_abbr='lhx' WHERE id=44;
UPDATE medicine SET chemical_name_abbr='bhsaldp',name_abbr='ysd' WHERE id=45;
UPDATE medicine SET chemical_name_abbr='bhsaldp',name_abbr='xln' WHERE id=46;
UPDATE medicine SET chemical_name_abbr='hbszxaldp',name_abbr='shd' WHERE id=47;
UPDATE medicine SET chemical_name_abbr='jhsaldp',name_abbr='xlp' WHERE id=48;
UPDATE medicine SET chemical_name_abbr='lxdp',name_abbr='lxp' WHERE id=49;
UPDATE medicine SET chemical_name_abbr='fldphsp',name_abbr='byd' WHERE id=50;
UPDATE medicine SET chemical_name_abbr='xbdpksp',name_abbr='bxt' WHERE id=51;
UPDATE medicine SET chemical_name_abbr='xbdphsp',name_abbr='stp' WHERE id=52;

-- 修改药物表字段类型
ALTER TABLE medicine MODIFY using_frequency VARCHAR(255);

-- 药物是否生效默认为true
UPDATE medicine  SET isactive=true;