import {Component, Input, OnInit} from '@angular/core';
import {ITheme} from '../themes.model';

@Component({
  selector: 'theme-list-item',
  templateUrl: './theme-list-item.component.html',
  styleUrls: ['./theme-list-item.component.scss']
})
export class ThemeListItemComponent implements OnInit {

  @Input() theme: ITheme;
  @Input() width: number;

  constructor() { }

  ngOnInit() {
  }
}
