import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'theme-list-item',
  templateUrl: './theme-list-item.component.html',
  styleUrls: ['./theme-list-item.component.scss']
})
export class ThemeListItemComponent implements OnInit {

  @Input() theme: IThemes;

  constructor() { }

  ngOnInit() {
  }
}
