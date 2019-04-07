/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';+
    config.toolbar = 'Cms';
    config.image_previewText=' '; //预览区域显示内容
    config.filebrowserImageUploadUrl= "/file/upload/ckeditor"
    config.toolbar_Cms =
    [
        ['Source','-'],
        ['Cut','Copy','Paste','PasteText','PasteFromWord','-'],
        ['Undo','Redo','-','Find','Replace','RemoveFormat'],['Link','Unlink','Anchor'],
        ['Image','Flash','Table','HorizontalRule', '-'],['Maximize'],
    '/',
    ['Bold','Italic','Underline','Strike','-'],
        ['FontSize'],['TextColor','BGColor'],
        ['NumberedList','BulletedList','-','Outdent','Indent','pre'],
        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
        ['PageBreak', 'Page']
    ];
};
