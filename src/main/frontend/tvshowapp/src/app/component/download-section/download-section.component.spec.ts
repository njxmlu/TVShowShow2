import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DownloadSectionComponent } from './download-section.component';

describe('DownloadSectionComponent', () => {
  let component: DownloadSectionComponent;
  let fixture: ComponentFixture<DownloadSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DownloadSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DownloadSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
